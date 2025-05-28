package com.deliveryfood.web.converter;

import com.deliveryfood.domain.Product;
import com.deliveryfood.repository.ProductRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductByIdConverter implements Converter<String, Product> {
    private final ProductRepository productRepository;

    public ProductByIdConverter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product convert(String id) {
        return productRepository.findById(Long.valueOf(id)).orElse(null);
    }
}
