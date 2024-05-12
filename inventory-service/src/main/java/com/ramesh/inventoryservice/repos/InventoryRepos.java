package com.ramesh.inventoryservice.repos;

import com.ramesh.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepos extends JpaRepository<Inventory, Long> {

  boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, int quantity);
}
