package com.example.ProjectCamunda.repository;

import com.example.ProjectCamunda.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByItemName(String itemName);
}