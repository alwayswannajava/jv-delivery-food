package com.deliveryfood.domain;

import com.deliveryfood.common.Status;
import lombok.Data;
import java.math.BigDecimal;
import java.util.*;

@Data
public class Order {
    private Long id;
    private UUID orderId;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private Status status = Status.IN_PROGRESS;
    private String customerName;
    private Set<MenuItem> menuItems = new HashSet<>();
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public void addMenuItems(Set<MenuItem> menuItems) {
        this.menuItems.addAll(menuItems);
    }
}
