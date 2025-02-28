package com.productservice.service;

import com.productservice.dto.converter.ProductConverter;
import com.productservice.dto.ProductDto;
import com.productservice.dto.ProductPostRequest;
import com.productservice.model.Category;
import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.categoryService = categoryService;
    }

    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return productConverter.toProductDto(product);
    }

    public List<ProductDto> getByCategoryId(Long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);

        if(products.isEmpty()) {
            throw new EntityNotFoundException("Products not found");
        }

        return products.stream().map(productConverter::toProductDto).collect(Collectors.toList());
    }

    public URI addProduct(ProductPostRequest productPostRequest, Long categoryId) {
        Product product = new Product();
        product.setName(productPostRequest.getName());
        product.setDescription(productPostRequest.getDescription());
        product.setPrice(productPostRequest.getPrice());

        Category category = categoryService.getById(categoryId);
        product.setCategory(category);

        productRepository.save(product);

        return UriComponentsBuilder.fromPath("/api/v1/products/{id}")
                .buildAndExpand(product.getId())
                .toUri();
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}
