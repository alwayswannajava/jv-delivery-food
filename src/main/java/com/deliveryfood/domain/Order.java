package com.deliveryfood.domain;

import com.deliveryfood.common.Status;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private Status status;
    private String customerName;
    private List<MenuItem> menuItems = new ArrayList<>();


    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }
}
