package com.deliveryfood.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
public class Menu {
    private String name;
    private Set<MenuItem> menuItems;
}
