package com.productservice.controller;

import com.productservice.dto.ProductDto;
import com.productservice.dto.ProductPostRequest;
import com.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(String id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(String categoryId) {
        return ResponseEntity.ok(productService.getByCategoryId(categoryId));
    }

    @PostMapping("/categories/{categoryId}")
    public ResponseEntity<?> addProduct(ProductPostRequest productPostRequest, String categoryId) {
        return ResponseEntity.ok(productService.addProduct(productPostRequest, categoryId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
