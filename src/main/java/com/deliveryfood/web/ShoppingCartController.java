package com.deliveryfood.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@RequestMapping("/v1/shopping-cart")
@SessionAttributes("shoppingCart")
public class ShoppingCartController {
    private static final String SHOPPING_CART_VIEW = "shopping-cart";

    @GetMapping("/current")
    public String showShoppingCart() {
        log.info("----------------------GET-------------------------");
        log.info("Showing shopping cart view");
        return SHOPPING_CART_VIEW;
    }
}
