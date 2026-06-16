package com.example.game_market.controller;

import com.example.game_market.entity.Product;
import com.example.game_market.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product product){

        return productService.update(id, product);
    }
}