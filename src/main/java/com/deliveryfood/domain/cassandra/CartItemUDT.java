package com.deliveryfood.domain.cassandra;

import com.deliveryfood.common.Type;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import com.datastax.oss.driver.api.core.type.DataType;

@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@UserDefinedType("cart_item")
public class CartItemUDT {
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;

    @CassandraType(type = CassandraType.Name.TEXT)
    private Type type;

    @CassandraType(type = CassandraType.Name.INT)
    private int quantity;
}
