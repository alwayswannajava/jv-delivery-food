package com.deliveryfood.web;

import com.deliveryfood.common.Type;
import com.deliveryfood.domain.cassandra.CartItemUDT;
import com.deliveryfood.domain.postgres.Menu;
import com.deliveryfood.domain.cassandra.ShoppingCart;
import com.deliveryfood.repository.ProductRepository;
import com.deliveryfood.repository.ShoppingCartRepository;
import com.deliveryfood.repository.projection.ProductProjection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/v1/menu")
@SessionAttributes("shoppingCart")
public class MenuController {
    private static final String MENU_VIEW = "menu";
    private static final String REDIRECT_TO_SHOPPING_CART_VIEW = "redirect:/v1/shopping-cart/current";

    private final ProductRepository productRepository;

    public MenuController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ModelAttribute("menu")
    public Menu menu() {
        return new Menu();
    }

    @ModelAttribute("shoppingCart")
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

    @GetMapping
    public String showMenu(Model model) {
        log.info("----------------------GET-------------------------");
        log.info("Showing menu view");
        Type[] types = Type.values();
        List<ProductProjection> products = productRepository.findAllBy();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(products, type));
        }
        return MENU_VIEW;
    }

    @PostMapping
    public String processMenu(
            @ModelAttribute("menuDto") Menu menu,
            @ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {
        log.info("----------------------POST-------------------------");
        log.info("Before processing menu items: {}", menu.getProducts());
        menu.getProducts().forEach(product -> {
            final CartItemUDT cartItem = new CartItemUDT();
            cartItem.setName(product.getName());
            cartItem.setType(product.getType());
            shoppingCart.addCartItem(cartItem);
        });
        log.info("After processing menu items: {}", shoppingCart.getShoppingCartItems());
        return REDIRECT_TO_SHOPPING_CART_VIEW;
    }

    private Iterable<ProductProjection> filterByType(List<ProductProjection> items, Type type) {
        return items.stream()
                .filter(item -> item.getType().equals(type))
                .toList();
    }
}
