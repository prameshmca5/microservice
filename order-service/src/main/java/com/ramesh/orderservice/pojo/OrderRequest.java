package com.ramesh.orderservice.pojo;

import java.math.BigDecimal;

public record OrderRequest(
  String orderNumber,
  String skuCode,
  BigDecimal price,
  Integer quantity,

  String status
) {
}
