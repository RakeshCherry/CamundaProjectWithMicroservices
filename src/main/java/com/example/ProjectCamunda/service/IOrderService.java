package com.example.ProjectCamunda.service;

import com.example.ProjectCamunda.dto.CustomerDetailsDto;
import com.example.ProjectCamunda.dto.OrderDto;
import com.example.ProjectCamunda.entity.Order;

public interface IOrderService {
    void createOrder(Order order);
}
