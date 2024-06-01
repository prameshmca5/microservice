package com.ramesh.orderservice.client;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class RestClientConfig {

  private String inventoryUrl = "http://localhost:8084";

  @Bean
  public InventoryClient inventoryClient() {
    RestClient restClient = RestClient.builder()
        .baseUrl(inventoryUrl)
        .requestFactory(clientHttpRequestFactory())
        .build();
    var restClientAdaptor = RestClientAdapter.create(restClient);
    var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdaptor).build();
    return httpServiceProxyFactory.createClient(InventoryClient.class);
  }

  private ClientHttpRequestFactory clientHttpRequestFactory() {
    ClientHttpRequestFactorySettings factory =
        ClientHttpRequestFactorySettings.DEFAULTS
            .withConnectTimeout(Duration.ofSeconds(3))
            .withReadTimeout(Duration.ofSeconds(3));
    return ClientHttpRequestFactories.get(factory);

  }
}
