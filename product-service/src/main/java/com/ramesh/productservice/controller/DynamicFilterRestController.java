package com.ramesh.productservice.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ramesh.productservice.dto.Employee;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicFilterRestController {

  @GetMapping("/filter")
  public MappingJacksonValue filterDynamicValue() {
    FilterProvider filters = new SimpleFilterProvider().addFilter("1", SimpleBeanPropertyFilter.filterOutAllExcept("name","email"));
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new Employee("Employee 1", "employee1@company.com", 100000));
    mappingJacksonValue.setFilters(filters);
    return mappingJacksonValue;
  }
}
