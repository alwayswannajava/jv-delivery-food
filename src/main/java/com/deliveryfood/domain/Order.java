package com.deliveryfood.domain;

import com.deliveryfood.common.PaymentMethod;
import com.deliveryfood.common.Status;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import java.math.BigDecimal;
import java.util.*;

@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NaturalId
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;

    @NotBlank(message = "Delivery street is required")
    private String deliveryStreet;
    @NotBlank(message = "Delivery city is required")
    private String deliveryCity;
    @NotBlank(message = "Delivery state is required")
    private String deliveryState;
    @NotBlank(message = "Delivery zip is required")
    private String deliveryZip;
    private Status status = Status.IN_PROGRESS;
    private String customerName;
    private Set<Product> products = new HashSet<>();
    private BigDecimal totalPrice = BigDecimal.ZERO;
    @NotNull(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    public void addMenuItems(Set<Product> products) {
        this.products.addAll(products);
    }
}
