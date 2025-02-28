package com.productservice.dto.converter;

import com.productservice.dto.ProductDto;
import com.productservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDto toProductDto(Product product) {

        if (product == null) {
            return null;
        }

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getName());
    }

}
