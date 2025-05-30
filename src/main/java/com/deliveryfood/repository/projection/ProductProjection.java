package com.deliveryfood.repository.projection;

import com.deliveryfood.common.Type;
import java.math.BigDecimal;

public interface ProductProjection {
    Long getId();
    String getName();
    String getDescription();
    BigDecimal getPrice();
    Type getType();
}
