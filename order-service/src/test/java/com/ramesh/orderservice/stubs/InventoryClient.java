package com.ramesh.orderservice.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClient {


  public static void stubInventoryCall(String skuCode, int quantity) {
    stubFor(get(urlPathEqualTo("/api/v1/inventory/isStock" + "?skuCode=" + skuCode + "&quantity=" + quantity))
        .willReturn(aResponse().withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("true")
        ));
  }
}
