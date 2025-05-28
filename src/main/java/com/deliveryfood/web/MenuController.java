package com.deliveryfood.web;

import com.deliveryfood.common.Type;
import com.deliveryfood.domain.Menu;
import com.deliveryfood.domain.Order;
import com.deliveryfood.domain.Product;
import com.deliveryfood.domain.ShoppingCart;
import com.deliveryfood.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @GetMapping
    public String showMenu(Model model) {
        log.info("----------------------GET-------------------------");
        log.info("Showing menu view");
        Type[] types = Type.values();
        List<Product> products = productRepository.findAll();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(products, type));
        }
        return MENU_VIEW;
    }

    @PostMapping
    public String processMenu(
            @ModelAttribute("menu") Menu menu,
            @ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {
        log.info("----------------------POST-------------------------");
        log.info("Before processing menu items: {}", menu.getProducts());

        log.info("After processing menu items: {}", shoppingCart.getShoppingCartItems());
        return REDIRECT_TO_SHOPPING_CART_VIEW;
    }

    private Iterable<Product> filterByType(List<Product> items, Type type) {
        return items.stream()
                .filter(item -> item.getType().equals(type))
                .toList();
    }
}
