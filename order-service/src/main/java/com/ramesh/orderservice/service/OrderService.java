package com.ramesh.orderservice.service;

import com.ramesh.orderservice.client.InventoryClient;
import com.ramesh.orderservice.entity.OrderProduct;
import com.ramesh.orderservice.pojo.OrderRequest;
import com.ramesh.orderservice.pojo.OrderResponse;
import com.ramesh.orderservice.repos.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  private final InventoryClient inventoryClient;


  public OrderProduct placeOrder(OrderRequest orderRequest) {
    OrderProduct orderProduct = new OrderProduct();
    var isPresentInStock = inventoryClient.isStockAvailable(orderRequest.skuCode(), orderRequest.quantity());
    if(!isPresentInStock) {
      throw new RuntimeException("Product with skuCode " + orderRequest.skuCode() + " is out of stock");
    }else {

      orderProduct.setOrderNumber(UUID.randomUUID().toString());
      orderProduct.setPrice(orderRequest.price());
      orderProduct.setSkuCode(orderRequest.skuCode());
      orderProduct.setQuantity(orderRequest.quantity());
      // save order
      orderProduct = orderRepository.save(orderProduct);
      System.out.println("Order placed successfully");
      return orderProduct;
    }
  }

  public List<OrderProduct> getAllOrders() {
    return orderRepository.findAll();
  }
}
