package com.deliveryfood.domain.cassandra;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table("shopping_carts")
@Getter
@Setter
@EqualsAndHashCode
public class ShoppingCart {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private final UUID cartReference = UUID.randomUUID();

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING)
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column("shopping_cart_items")
    @CassandraType(type = CassandraType.Name.SET, typeArguments = CassandraType.Name.UDT,
            userTypeName = "cart_item")
    private Set<CartItemUDT> shoppingCartItems = new HashSet<>();

    public void addCartItem(CartItemUDT item) {
        shoppingCartItems.add(item);
    }
}
