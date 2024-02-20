package com.prashant.repository;

import com.prashant.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo  extends ReactiveMongoRepository<Product, String> {
}
