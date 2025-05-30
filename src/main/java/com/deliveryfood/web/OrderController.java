package com.deliveryfood.web;

import com.deliveryfood.domain.postgres.Order;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/v1/orders")
@SessionAttributes("order")
public class OrderController {
    private static final String CURRENT_ORDER_VIEW = "current";
    private static final String ORDER_SUCCESSFUL_VIEW = "order-successful";
    private static final String REDIRECT_TO_ORDER_SUCCESSFUL_VIEW = "redirect:/v1/orders/order-successful";
    private static final String REDIRECT_TO_ORDER_UNSUCCESSFUL_VIEW = "redirect:/v1/orders/order-unsuccessful";


    @GetMapping("/current")
    public String showOrder() {
        log.info("----------------------GET-------------------------");
        log.info("Showing current order");
        return CURRENT_ORDER_VIEW;
    }

    @GetMapping("/order-successful")
    public String showOrderSuccessful(@ModelAttribute("order") Order order, SessionStatus sessionStatus) {
        log.info("----------------------GET-------------------------");
        log.info("Showing order successful");
        sessionStatus.setComplete();
        log.info("Order completed: {}", order);
        return ORDER_SUCCESSFUL_VIEW;
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return CURRENT_ORDER_VIEW;
        }
        log.info("----------------------POST-------------------------");
        log.info("Processing order {}", order);
        log.info("Processing order {}", order);
        return REDIRECT_TO_ORDER_SUCCESSFUL_VIEW;
    }
}
