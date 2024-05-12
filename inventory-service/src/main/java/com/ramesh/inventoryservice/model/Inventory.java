package com.ramesh.inventoryservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "t_inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  private String skuCode;
  private int quantity;
  private Timestamp createdDate;
}