package com.example.ProjectCamunda.service;

import com.example.ProjectCamunda.dto.CustomerDetailsDto;
import com.example.ProjectCamunda.dto.OrderDto;

public interface IOrderService {
    void createOrder(OrderDto orderDto);
}
