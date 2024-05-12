package com.ramesh.orderservice.client;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

  private String inventoryUrl = "http://localhost:8084";

  @Bean
  public InventoryClient inventoryClient() {
    RestClient restClient = RestClient.builder()
        .baseUrl(inventoryUrl)
        .build();
    var restClientAdaptor = RestClientAdapter.create(restClient);
    var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdaptor).build();
    return httpServiceProxyFactory.createClient(InventoryClient.class);
  }
}
