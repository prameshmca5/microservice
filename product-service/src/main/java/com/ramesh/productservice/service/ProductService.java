package com.ramesh.productservice.service;

import com.ramesh.productservice.dto.ProductRequest;
import com.ramesh.productservice.dto.ProductResponse;
import com.ramesh.productservice.model.Product;
import com.ramesh.productservice.repos.ProductRepos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductRepos productRepos;


  public Product addProduct(ProductRequest productRequest) {
    Product product = Product.builder()
        .name(productRequest.name())
        .description(productRequest.description())
        .price(productRequest.price())
        .build();
    productRepos.save(product);
    log.info("Product service is created");
    log.info("Product {} saved", product.getId());
    return product;
  }

  public List<Product> findAll() {
    List<Product> products = productRepos.findAll();
     return products;
  }
}
