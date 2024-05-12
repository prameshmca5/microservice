package com.ramesh.orderservice;

import com.ramesh.orderservice.stubs.InventoryClient;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

  static MySQLContainer mysql = new MySQLContainer("mysql:8.0.32");

  @LocalServerPort
  private Integer port;

  static{
    mysql.start();
  }


  @BeforeEach
  void setUp() {
    RestAssured.baseURI = "http://localhost:8083";
    RestAssured.port = port;
  }

  @Test
  void shouldCreateOrder() {

    String requestBody = "{\n" +
        "  \"skuCode\": \"iPhone\",\n" +
        "  \"price\": 1000,\n" +
        "  \"status\": \"IN_PROGRESS\",\n" +
        "  \"quantity\": 1\n" +
        "}";

   // InventoryClient.stubInventoryCall("iPhone", 1);

    RestAssured.given()
        .contentType("application/json")
        .body(requestBody)
        .when()
        .request("POST", "/api/v1/orders")
        .then()
        .statusCode(201)
        .body("orderNumber", notNullValue())
        .body("skuCode", equalTo("iPhone_13"))
        .body("price", equalTo(1000))
        .body("status", equalTo("IN_PROGRESS"))
        .body("quantity", equalTo(1));
  }

}
