package com.example.ProjectCamunda.delegates;

import com.example.ProjectCamunda.entity.Inventory;
import com.example.ProjectCamunda.entity.Order;
import com.example.ProjectCamunda.repository.InventoryRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidInventoryDelegate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(ValidInventoryDelegate.class);
    private final InventoryRepository inventoryRepository;

    public ValidInventoryDelegate(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Get the order object from the process variables
        Order order = (Order) execution.getVariable("order");

        // Check if the inventory is valid
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(order.getItemId());
        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();
            log.info("Inventory: " + inventory.getInventoryBalance());
            if (inventory.getInventoryBalance() < order.getNoOfItems()) {
                execution.setVariable("isvalidInventory", false);
            } else {
                execution.setVariable("isvalidInventory", true);
            }
        } else {
            log.error("Inventory not found for item ID: " + order.getItemId());
            execution.setVariable("isvalidInventory", false);
        }
    }
}