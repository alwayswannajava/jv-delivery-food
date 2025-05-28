package com.deliveryfood.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "menu")
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "products")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_menu_id")
    @SequenceGenerator(name = "seq_menu_id", sequenceName = "seq_menu_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "menu")
    private Set<Product> products;
}
