package com.deliveryfood.domain;

import com.deliveryfood.common.PaymentMethod;
import com.deliveryfood.common.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"orderItems"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order_id")
    @SequenceGenerator(name = "seq_order_id", sequenceName = "seq_order_id")
    private Long id;

    @NaturalId
    @Column(nullable = false)
    private UUID orderReference;

    @Column(nullable = false)
    private String deliveryStreet;

    @Column(nullable = false)
    private String deliveryCity;

    @Column(nullable = false)
    private String deliveryState;

    @Column(nullable = false)
    private String deliveryZip;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    public void addOrderItems(Set<OrderItem> orderItems) {
        this.orderItems.addAll(orderItems);
    }
}
