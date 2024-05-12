package com.ramesh.productservice.dto;

import com.fasterxml.jackson.core.JsonToken;

import java.math.BigDecimal;


public record ProductResponse(
  String id,  String name, String description, BigDecimal price
) {
}
