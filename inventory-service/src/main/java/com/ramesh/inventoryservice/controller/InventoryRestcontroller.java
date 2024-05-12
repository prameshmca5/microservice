package com.ramesh.inventoryservice.controller;

import com.ramesh.inventoryservice.model.Inventory;
import com.ramesh.inventoryservice.pojo.InventoryRequest;
import com.ramesh.inventoryservice.pojo.InventoryResponse;
import com.ramesh.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
public class InventoryRestcontroller {

  private final InventoryService inventoryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public InventoryResponse addInventory(@RequestBody InventoryRequest inventoryRequest) {
    Inventory inventory = inventoryService.addInventory(inventoryRequest);
    return new InventoryResponse(inventory.getSkuCode(), inventory.getQuantity(), inventory.getCreatedDate());
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<InventoryResponse> getAllInventory() {
    return inventoryService.getAllInventory()
        .stream().map(res->new InventoryResponse(res.getSkuCode(), res.getQuantity(), res.getCreatedDate()  )).toList();
  }

  @GetMapping("/isStock")
  @ResponseStatus(HttpStatus.OK)
  public boolean isStockAvailable(@RequestParam String skuCode, @RequestParam int quantity) {
    return inventoryService.isStockAvailable(skuCode, quantity);
  }

}
