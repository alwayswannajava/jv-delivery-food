package com.deliveryfood.repository;

import com.deliveryfood.domain.cassandra.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
