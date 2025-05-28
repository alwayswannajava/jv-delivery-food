package com.deliveryfood.domain;

import com.deliveryfood.common.Type;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@NoArgsConstructor(force = true)
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_id")
    @SequenceGenerator(name = "seq_product_id", sequenceName = "seq_product_id")
    private Long id;

    @NaturalId
    @Column(name = "product_reference", nullable = false)
    private UUID productReference;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
}
