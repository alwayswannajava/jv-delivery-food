package com.deliveryfood.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "shopping_carts")
@NoArgsConstructor(force = true)
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cart_id")
    @SequenceGenerator(name = "seq_cart_id", sequenceName = "seq_cart_id")
    private Long id;

    @NaturalId
    @Column(nullable = false)
    private UUID cartReference;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> shoppingCartItems;
}
