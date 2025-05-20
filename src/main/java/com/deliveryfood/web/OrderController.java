package com.deliveryfood.web;

import com.deliveryfood.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/v1/orders")
@SessionAttributes("order")
public class OrderController {

    @GetMapping("/current")
    public String showOrder() {
        return "current";
    }

    @GetMapping("/order-successful")
    public String showOrderSuccessful() {
        return "order-successful";
    }

    @PostMapping
    public String processOrder(@ModelAttribute("order") Order order, SessionStatus sessionStatus) {
        log.info("----------------------POST-------------------------");
        log.info("Processing order {}", order);
        sessionStatus.setComplete();
        return "redirect:/v1/orders/order-successful";
    }
}
