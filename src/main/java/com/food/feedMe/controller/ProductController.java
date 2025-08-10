package com.food.feedMe.controller;


import com.food.feedMe.product.Product;
import com.food.feedMe.product.ProductDto;
import com.food.feedMe.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductDto> getProductByName(
            @PathVariable("name") String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }


}
