package com.example.game_market.service;

import com.example.game_market.entity.Product;
import com.example.game_market.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product update(Long id, Product product){

        Product findProduct = productRepository.findById(id)
                .orElseThrow();

        findProduct.setTitle(product.getTitle());
        findProduct.setDescription(product.getDescription());
        findProduct.setPrice(product.getPrice());
        findProduct.setPlatform(product.getPlatform());

        return productRepository.save(findProduct);
    }

    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("상품 없음"));
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}