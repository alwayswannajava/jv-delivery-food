package com.deliveryfood.web;

import com.deliveryfood.domain.Menu;
import com.deliveryfood.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/v1/menu")
@SessionAttributes("order")
public class MenuController {
    private static final String MENU_VIEW = "menu";
    private static final String REDIRECT_TO_ORDER_VIEW = "redirect:/v1/orders/current";

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute("menu")
    public Menu menu() {
        return new Menu();
    }

    @GetMapping
    public String showMenu() {
        return MENU_VIEW;
    }

    @PostMapping
    public String processMenu(
            @ModelAttribute("menu") Menu menu,
            @ModelAttribute("order") Order order) {
        log.info("----------------------POST-------------------------");
        log.info("Before processing menu items: {}", menu.getProducts());
        order.addMenuItems(menu.getProducts());
        log.info("After processing menu items: {}", order.getProducts());
        return REDIRECT_TO_ORDER_VIEW;
    }
}
