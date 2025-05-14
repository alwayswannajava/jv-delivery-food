package com.deliveryfood.controller;

import com.deliveryfood.common.Type;
import com.deliveryfood.domain.Menu;
import com.deliveryfood.domain.MenuItem;
import com.deliveryfood.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/menu")
@SessionAttributes("order")
public class MenuController {
    @ModelAttribute
    public void addMenuItemsToModel(Model model) {
        List<MenuItem> items = Arrays.asList(
                new MenuItem("Pizza", "Delicious cheese pizza", BigDecimal.valueOf(8.99), Type.FOOD),
                new MenuItem("Burger", "Juicy beef burger", BigDecimal.valueOf(5.99), Type.FOOD),
                new MenuItem("Soda", "Refreshing soda", BigDecimal.valueOf(1.99), Type.DRINK)
        );
        model.addAttribute("menuItems", items);
    }

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute("menu")
    public Menu menu() {
        return new Menu();
    }

    @GetMapping
    public String showMenu(Model model) {
        return "menu";
    }
}
