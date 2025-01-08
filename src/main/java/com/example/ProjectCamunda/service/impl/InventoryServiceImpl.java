package com.example.ProjectCamunda.service.impl;

import com.example.ProjectCamunda.dto.InventoryDto;
import com.example.ProjectCamunda.entity.Inventory;
import com.example.ProjectCamunda.mapper.InventoryMapper;
import com.example.ProjectCamunda.repository.InventoryRepository;
import com.example.ProjectCamunda.service.IInventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements IInventoryService {

    private InventoryRepository inventoryRepository;

    public void createInventory(InventoryDto inventoryDto) {
        inventoryRepository.save(InventoryMapper.mapToInventory(inventoryDto, new Inventory()));
    }
}
