package com.deliveryfood.domain;

import com.deliveryfood.common.Type;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Product {
    private final Long id;
    private final UUID productId;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Type type;
}
