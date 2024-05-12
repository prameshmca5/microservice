package com.ramesh.inventoryservice.service;

import com.ramesh.inventoryservice.model.Inventory;
import com.ramesh.inventoryservice.pojo.InventoryRequest;
import com.ramesh.inventoryservice.repos.InventoryRepos;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class InventoryService {

  private final InventoryRepos inventoryRepos;

  public Inventory addInventory(InventoryRequest inventoryRequest) {
    Inventory inventory = new Inventory();
    inventory.setSkuCode(inventoryRequest.skuCode());
    inventory.setQuantity(inventoryRequest.quantity());
    inventory.setCreatedDate(new Timestamp(System.currentTimeMillis()));
    inventory = inventoryRepos.save(inventory);
    return inventory;
  }

  public List<Inventory> getAllInventory() {
    return inventoryRepos.findAll();
  }

  public boolean isStockAvailable(String skuCode, int quantity) {
    return inventoryRepos.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
  }
}
