package com.ramesh.orderservice.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

//@FeignClient(name = "inventory-service", url = "http://localhost:8084")
public interface InventoryClient {

 // @RequestMapping(value = "/api/v1/inventory/isStock", method = RequestMethod.GET)
  @GetExchange("/api/v1/inventory/isStock")
  boolean isStockAvailable(@RequestParam String skuCode, @RequestParam int quantity);
}
