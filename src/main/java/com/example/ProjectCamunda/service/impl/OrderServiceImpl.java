package com.example.ProjectCamunda.service.impl;

import com.example.ProjectCamunda.dto.InventoryDto;
import com.example.ProjectCamunda.dto.OrderDto;
import com.example.ProjectCamunda.entity.Inventory;
import com.example.ProjectCamunda.entity.Order;
import com.example.ProjectCamunda.mapper.InventoryMapper;
import com.example.ProjectCamunda.mapper.OrderMapper;
import com.example.ProjectCamunda.repository.InventoryRepository;
import com.example.ProjectCamunda.repository.OrderRepository;
import com.example.ProjectCamunda.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private OrderRepository orderRepository;
    private InventoryRepository inventoryRepository;

    @Override
    public void createOrder(OrderDto orderDto) {
        Inventory inventory = inventoryRepository.findByItemName(orderDto.getItem());
        Order order = OrderMapper.mapToOrder(orderDto, new Order());
        if (inventory.getInventoryBalance() < orderDto.getNoOfItems()) {
            throw new RuntimeException("Not enough inventory");
        }else if (inventory.getInventoryBalance() == 0) {
                throw new RuntimeException("Item type not available");
            }
        else if (orderDto.getNoOfItems() <= 0) {
            throw new RuntimeException("No. of items should be greater than 0");
        }else {
            orderRepository.save(order);
            inventory.setInventoryBalance(inventory.getInventoryBalance() - orderDto.getNoOfItems());
            inventoryRepository.save(inventory);
        }
    }


}
