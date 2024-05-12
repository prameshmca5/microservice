package com.ramesh.productservice.repos;

import com.ramesh.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepos extends MongoRepository<Product, String> {

}
