package com.deliveryfood.controller;

import com.deliveryfood.common.Type;
import com.deliveryfood.domain.MenuItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class MenuItemByIdConverter implements Converter<String, MenuItem> {
    private final Map<Long, MenuItem> menuItems = new HashMap<>();

    public MenuItemByIdConverter() {
        menuItems.put(1L, new MenuItem(1L, "Pizza",
                        "Delicious cheese pizza", BigDecimal.valueOf(8.99), Type.FOOD));
                menuItems.put(2L, new MenuItem(2L,"Burger",
                        "Juicy beef burger", BigDecimal.valueOf(5.99), Type.FOOD));
                menuItems.put(3L, new MenuItem(3L,"Soda",
                        "Refreshing soda", BigDecimal.valueOf(1.99), Type.DRINK));
    }

    @Override
    public MenuItem convert(String id) {
        return menuItems.get(id);
    }
}
