package com.example.ProjectCamunda.mapper;

import com.example.ProjectCamunda.dto.InventoryDto;
import com.example.ProjectCamunda.entity.Inventory;

public class InventoryMapper {

    public static InventoryDto mapToInventoryDto(Inventory inventory, InventoryDto inventoryDto) {
        inventoryDto.setItemId(inventory.getItemId());
        inventoryDto.setItemName(inventory.getItemName());
        inventoryDto.setItemType(inventory.getItemType());
        inventoryDto.setPricePerUnit(inventory.getPricePerUnit());
        inventoryDto.setInventoryBalance(inventory.getInventoryBalance());
        return inventoryDto;
    }

    public static Inventory mapToInventory(InventoryDto inventoryDto, Inventory inventory) {
        inventory.setItemId(inventoryDto.getItemId());
        inventory.setItemName(inventoryDto.getItemName());
        inventory.setItemType(inventoryDto.getItemType());
        inventory.setPricePerUnit(inventoryDto.getPricePerUnit());
        inventory.setInventoryBalance(inventoryDto.getInventoryBalance());
        return inventory;
    }
}
