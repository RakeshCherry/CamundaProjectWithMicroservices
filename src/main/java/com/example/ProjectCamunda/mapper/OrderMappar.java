package com.example.ProjectCamunda.mapper;


import com.example.ProjectCamunda.dto.OrderDto;

public class OrderMappar {

    public static OrderDto mapToOrderDto(OrderDto orderDto) {
        orderDto.setItemId(orderDto.getItemId());
        orderDto.setCustomerDetails(orderDto.getCustomerDetails());
        orderDto.setNoOfItems(orderDto.getNoOfItems());
        return orderDto;
    }

    public static OrderDto mapToOrder(OrderDto orderDto) {
        orderDto.setItemId(orderDto.getItemId());
        orderDto.setCustomerDetails(orderDto.getCustomerDetails());
        orderDto.setNoOfItems(orderDto.getNoOfItems());
        return orderDto;
    }
}
