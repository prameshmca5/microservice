package com.ramesh.orderservice.controller;

import com.ramesh.orderservice.entity.OrderProduct;
import com.ramesh.orderservice.pojo.OrderRequest;
import com.ramesh.orderservice.pojo.OrderResponse;
import com.ramesh.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

  private final OrderService orderService;

  @RequestMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
    OrderProduct orderProduct = orderService.placeOrder(orderRequest);
    return new OrderResponse(orderProduct.getOrderNumber(), orderProduct.getSkuCode(), orderProduct.getPrice(), orderProduct.getQuantity(), orderProduct.getStatus());
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<OrderResponse> getAllOrders() {
    return orderService.getAllOrders()
        .stream().map(res->new OrderResponse(res.getOrderNumber(), res.getSkuCode(), res.getPrice(), res.getQuantity(), res.getStatus())).toList();
  }

}
