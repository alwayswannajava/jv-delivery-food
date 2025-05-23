package com.deliveryfood.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/v1/contacts")
public class ContactController {
    private static final String CONTACT_VIEW = "contacts";

    @GetMapping
    public String showContact() {
        log.info("--------------------GET---------------------");
        log.info("Showing contact view");
        return CONTACT_VIEW;
    }
}
