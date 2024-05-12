package com.ramesh.apigateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;

@Configuration
public class Routes {
  @Bean
  public RouterFunction<ServerResponse> productServiceRoute() {
    return GatewayRouterFunctions.route("product-service")
        .route(RequestPredicates.path("/api/v1/products/**"), HandlerFunctions.http("http://localhost:8082"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> inventoryServiceRoute() {
    return GatewayRouterFunctions.route("inventory-service")
        .route(RequestPredicates.path("/api/v1/inventory/**"), HandlerFunctions.http("http://localhost:8084"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> orderServiceRoute() {
    return GatewayRouterFunctions.route("order-service")
        .route(RequestPredicates.path("/api/v1/orders/**"), HandlerFunctions.http("http://localhost:8083"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> aggregateProductServiceRoute() {
    return GatewayRouterFunctions.route("product_service_swagger")
        .route(RequestPredicates.path("/aggregate/product-service/v3/api-doc"), HandlerFunctions.http("http://localhost:8082"))
        .filter(setPath("/api-docs"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> aggregateInventoryServiceRoute() {
    return GatewayRouterFunctions.route("inventory_service_swagger")
        .route(RequestPredicates.path("/aggregate/inventory-service/v3/api-doc"), HandlerFunctions.http("http://localhost:8084"))
        .filter(setPath("/api-docs"))
        .build();
  }


  @Bean
  public RouterFunction<ServerResponse> aggregateOrderServiceRoute() {
    return GatewayRouterFunctions.route("order_service_swagger")
        .route(RequestPredicates.path("/aggregate/order-service/v3/api-doc"), HandlerFunctions.http("http://localhost:8083"))
        .filter(setPath("/api-docs"))
        .build();
  }

}
