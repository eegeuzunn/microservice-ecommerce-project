package com.cartservice.feignClient;

import com.cartservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", path = "api/v1/products")
public interface ProductServiceClient {
    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id);

    @GetMapping("/categories/{categoryId}")
    ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId);
}
