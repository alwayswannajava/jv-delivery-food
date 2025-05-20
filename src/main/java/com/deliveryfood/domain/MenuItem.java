package com.deliveryfood.domain;

import com.deliveryfood.common.Type;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class MenuItem {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int quantity = 1;
    private final Type type;
}
