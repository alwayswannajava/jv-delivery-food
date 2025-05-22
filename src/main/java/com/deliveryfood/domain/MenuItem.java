package com.deliveryfood.domain;

import com.deliveryfood.common.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class MenuItem {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int quantity;
    private final Type type;
}
