package com.example.ProjectCamunda.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class InventoryDto {

    private String itemName;

    private String itemType;

    private double pricePerUnit;

    private int inventoryBalance;
}
