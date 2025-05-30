package com.deliveryfood.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "shopping_carts")
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "shoppingCartItems")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cart_id")
    @SequenceGenerator(name = "seq_cart_id", sequenceName = "seq_cart_id")
    private Long id;

    @NaturalId
    @Column(nullable = false)
    private UUID cartReference;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> shoppingCartItems = new HashSet<>();

    public void addCartItem(CartItem item) {
        shoppingCartItems.add(item);
        item.setShoppingCart(this);
    }
}
