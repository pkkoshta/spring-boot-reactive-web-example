package com.prashant.service;

import com.prashant.entity.Product;
import com.prashant.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Flux<Product> getProducts(){
        return repo.findAll();
    }

    public Mono<Product> createProduct(Product product){
         return repo.save(product);
    }

    public Mono<Product> findById(String id){
        return repo.findById(id);
    }

    public Mono<Void> deleteProduct(String id){
        return repo.deleteById(id);
    }
}
