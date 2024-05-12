package com.ramesh.orderservice.repos;

import com.ramesh.orderservice.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderProduct, Long> {

}
