package com.ramesh.inventoryservice.pojo;

import java.sql.Timestamp;

public record InventoryResponse(
  String skuCode,
  int quantity,
  Timestamp createdDate
) {
}
