package com.deliveryfood.repository;

import com.deliveryfood.domain.Product;
import com.deliveryfood.repository.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<ProductProjection> findAllBy();
}
