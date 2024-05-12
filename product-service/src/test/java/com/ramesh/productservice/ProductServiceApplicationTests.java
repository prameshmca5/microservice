package com.ramesh.productservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testcontainers.containers.MongoDBContainer;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

  static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

  @LocalServerPort
  private Integer port;

  static{
    mongoDBContainer.start();
  }

  @BeforeEach
  void setUp() {
    RestAssured.baseURI = "http://localhost:8080";
    RestAssured.port = port;
  }
  @Test
	void shouldCreateProduct() {
    String requestBody = "{\n" +
        "  \"name\": \"iPhone\",\n" +
        "  \"description\": \"iPhone\",\n" +
        "  \"price\": 1000\n" +
        "}";

    RestAssured.given()
        .contentType("application/json")
        .body(requestBody)
        .when()
        .post("/api/v1/products")
        .then()
        .statusCode(201)
        .body("id", notNullValue())
        .body("name", equalTo("iPhone"))
        .body("description", equalTo("iPhone"))
        .body("price", equalTo(1000));
  }
}
