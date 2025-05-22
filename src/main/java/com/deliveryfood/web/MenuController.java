package com.deliveryfood.web;

import com.deliveryfood.common.Type;
import com.deliveryfood.domain.Menu;
import com.deliveryfood.domain.MenuItem;
import com.deliveryfood.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/v1/menu")
@SessionAttributes("order")
public class MenuController {
    private static final String REDIRECT_TO_ORDER_VIEW = "redirect:/v1/orders/current";

    @ModelAttribute
    public void addMenuItemsToModel(Model model) {
        List<MenuItem> items = Arrays.asList(
                new MenuItem(1L, "Pizza", "Delicious cheese pizza", BigDecimal.valueOf(8.99), 1, Type.FOOD),
                new MenuItem(2L,"Burger", "Juicy beef burger", BigDecimal.valueOf(5.99), 1, Type.FOOD),
                new MenuItem(3L,"Soda", "Refreshing soda", BigDecimal.valueOf(1.99), 1, Type.DRINK)
        );
        Type [] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(items, type));
        }
    }

    private Iterable<MenuItem> filterByType(List<MenuItem> items, Type type) {
        return items.stream()
                .filter(item -> item.getType().equals(type))
                .toList();
    }

    @ModelAttribute("order")
    public Order order(WebRequest request) {
        Order order = (Order) request.getAttribute("order", WebRequest.SCOPE_SESSION);
        if (order == null) {
            order = new Order();
        }
        return order;
    }

    @ModelAttribute("menu")
    public Menu menu() {
        return new Menu();
    }

    @GetMapping
    public String showMenu() {
        return "menu";
    }

    @PostMapping
    public String processMenu(
            @ModelAttribute("menu") Menu menu,
            @ModelAttribute("order") Order order) {
        log.info("----------------------POST-------------------------");
        log.info("Before processing menu items: {}", menu.getMenuItems());
        order.addMenuItems(menu.getMenuItems());
        log.info("After processing menu items: {}", order.getMenuItems());
        return REDIRECT_TO_ORDER_VIEW;
    }
}
