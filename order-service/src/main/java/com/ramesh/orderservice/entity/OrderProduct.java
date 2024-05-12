package com.ramesh.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "t_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String orderNumber;
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;
  private String status;
}
