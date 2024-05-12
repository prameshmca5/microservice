package com.ramesh.inventoryservice.pojo;

import java.sql.Timestamp;

public record InventoryRequest(
  String skuCode,
  int quantity,
 Timestamp createdDate

) {
}
