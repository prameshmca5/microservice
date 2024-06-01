package com.ramesh.apigateway.routes;

import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

import static com.thoughtworks.xstream.io.xml.xppdom.XppDom.build;
import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;

@Configuration
public class Routes {
  @Bean
  public RouterFunction<ServerResponse> productServiceRoute() {
    return route("product-service")
        .route(RequestPredicates.path("/api/v1/products/**"), HandlerFunctions.http("http://localhost:8082"))
        .filter(CircuitBreakerFilterFunctions.circuitBreaker("product-service",
            URI.create("forward:/fallbackRoute")))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> inventoryServiceRoute() {
    return route("inventory-service")
        .route(RequestPredicates.path("/api/v1/inventory/**"), HandlerFunctions.http("http://localhost:8084"))
        .filter(CircuitBreakerFilterFunctions.circuitBreaker("inventory-service",
            URI.create("forward:/fallbackRoute")))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> orderServiceRoute() {
    return route("order_service")
        .route(RequestPredicates.path("/api/v1/orders/**"), HandlerFunctions.http("http://localhost:8083"))
        .filter(CircuitBreakerFilterFunctions.circuitBreaker("order-service",
            URI.create("forward:/fallbackRoute")))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> aggregateProductServiceRoute() {
    return route("product_service")
        .route(RequestPredicates.path("/aggregate/product-service/v3/api/docs"), HandlerFunctions.http("http://localhost:8082"))
        .filter(CircuitBreakerFilterFunctions.circuitBreaker("product-service",
            URI.create("forward:/fallbackRoute")))
        .filter(setPath("/api/docs"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> aggregateInventoryServiceRoute() {
    return route("inventory_service")
        .route(RequestPredicates.path("/aggregate/inventory-service/v3/api/docs"), HandlerFunctions.http("http://localhost:8084"))
        .filter(CircuitBreakerFilterFunctions.circuitBreaker("inventory_service-service",
            URI.create("forward:/fallbackRoute")))
        .filter(setPath("/api/docs"))
        .build();
  }


  @Bean
  public RouterFunction<ServerResponse> aggregateOrderServiceRoute() {
    return route("order_service")
        .route(RequestPredicates.path("/aggregate/order-service/v3/api/docs"), HandlerFunctions.http("http://localhost:8083"))
        .filter(CircuitBreakerFilterFunctions.circuitBreaker("order-service",
            URI.create("forward:/fallbackRoute")))
        .filter(setPath("/api/docs"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> fallbackRoute() {
    return route(
        "fallbackRoute"
    ).GET("/fallbackRoute",
        request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE)
            .body("Service Unavailable Pleae try again later")).build();
  }

}
