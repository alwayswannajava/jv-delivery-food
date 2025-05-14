package com.deliveryfood.domain;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Menu {
    private UUID id;
    private String name;
    private List<MenuItem> menuItems;
}
