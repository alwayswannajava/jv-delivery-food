package com.deliveryfood.domain;

import com.deliveryfood.common.Status;
import lombok.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private Status status = Status.IN_PROGRESS;
    private String customerName;
    private List<MenuItem> menuItems = new ArrayList<>();
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public void addMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
