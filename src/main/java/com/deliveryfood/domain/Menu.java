package com.deliveryfood.domain;

import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
public class Menu {
    private String name;
    @OneToMany
    private Set<Product> products;
}
