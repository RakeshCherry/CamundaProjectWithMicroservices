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
        Long itemId = (Long) execution.getVariable("itemId");
        Integer noOfItems = (Integer) execution.getVariable("noOfItems");
        Double pricePerUnit = (Double) execution.getVariable("pricePerUnit");
        String itemType = (String) execution.getVariable("itemType");

        execution.setVariable("pricePerUnit", pricePerUnit);
        execution.setVariable("itemType", itemType);

        log.info("Item Price per Unit: {}", pricePerUnit);
        log.info("Item Type: {}", itemType);

        if (itemId == null) {
            log.error("Order is null in ValidInventoryDelegate");
            execution.setVariable("isValidInventory", false);
            return;
        }

        if (noOfItems == null || noOfItems <= 0) {
            log.error("Invalid number of items in the order: {}", noOfItems);
            execution.setVariable("isValidInventory", false);
            return;
        }

        Optional<Inventory> inventoryOptional = inventoryRepository.findById(itemId);
        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();

            if (inventory.getInventoryBalance() < noOfItems) {
                log.error("Insufficient inventory for item ID: {}. Available balance: {}, Requested: {}",
                        itemId, inventory.getInventoryBalance(), noOfItems);
                execution.setVariable("isValidInventory", false);
            } else {
                execution.setVariable("isValidInventory", true);
                log.info("Sufficient inventory for item ID: {}", itemId);
                log.info("Variable isValidInventory: {}", execution.getVariable("isValidInventory"));
            }
        } else {
            log.error("Inventory not found for item ID: " + itemId);
            execution.setVariable("isValidInventory", false);
        }
    }
}
