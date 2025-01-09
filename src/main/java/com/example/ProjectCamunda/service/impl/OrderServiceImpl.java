package com.example.ProjectCamunda.service.impl;

import com.example.ProjectCamunda.dto.CustomerDetailsDto;
import com.example.ProjectCamunda.dto.OrderDto;
import com.example.ProjectCamunda.entity.CustomerDetails;
import com.example.ProjectCamunda.entity.Inventory;
import com.example.ProjectCamunda.entity.Order;
import com.example.ProjectCamunda.exception.ResourceNotFoundException;
import com.example.ProjectCamunda.mapper.CustomerDetailsMapper;
import com.example.ProjectCamunda.mapper.OrderMapper;
import com.example.ProjectCamunda.repository.CustomerDetailsRepository;
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
    private CustomerDetailsRepository customerDetailsRepository;

    @Override
    public void createOrder(Order order) {
        Inventory inventory = inventoryRepository.findByItemName(order.getItem());
        if (inventory.getInventoryBalance() < order.getNoOfItems()) {
            throw new RuntimeException("Not enough inventory");
        }else if (inventory.getInventoryBalance() == 0) {
                throw new RuntimeException("Item type not available");
            }
        else if (order.getNoOfItems() <= 0) {
            throw new RuntimeException("No. of items should be greater than 0");
        }else {
            CustomerDetails customerDetails = new CustomerDetails();
            customerDetails.setCustomerName(order.getCustomerName());
            customerDetails.setCustomerType(order.getCustomerType());
            customerDetails.setMobileNumber(order.getMobileNumber());
            customerDetails.setPincode(order.getPincode());

            customerDetailsRepository.save(customerDetails);

            order.setItem(order.getItem());
            order.setNoOfItems(order.getNoOfItems());
            order.setCustomerDetails(customerDetails);
            customerDetails.setOrder(order);

            orderRepository.save(order);
            inventory.setInventoryBalance(inventory.getInventoryBalance() - order.getNoOfItems());
            inventoryRepository.save(inventory);
        }
    }
}
