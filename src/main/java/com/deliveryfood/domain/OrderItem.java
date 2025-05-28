package com.deliveryfood.domain;

import com.deliveryfood.common.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@NoArgsConstructor(force = true)
public class OrderItem {
    @Id
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int quantity;
    private final Type type;
}
