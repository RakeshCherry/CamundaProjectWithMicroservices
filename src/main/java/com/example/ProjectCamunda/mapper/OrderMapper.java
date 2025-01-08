package com.example.ProjectCamunda.mapper;

import com.example.ProjectCamunda.dto.CustomerDetailsDto;
import com.example.ProjectCamunda.dto.OrderDto;
import com.example.ProjectCamunda.entity.CustomerDetails;
import com.example.ProjectCamunda.entity.Order;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order, OrderDto orderDto) {
        orderDto.setItem(order.getItem());
        orderDto.setNoOfItems(order.getNoOfItems());
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setCustomerType(order.getCustomerType());
        orderDto.setMobileNumber(order.getMobileNumber());
        orderDto.setPincode(order.getPincode());
        return orderDto;
    }

    public static Order mapToOrder(OrderDto orderDto, Order order) {
        order.setItem(orderDto.getItem());
        order.setNoOfItems(orderDto.getNoOfItems());
        order.setCustomerName(orderDto.getCustomerName());
        order.setCustomerType(orderDto.getCustomerType());
        order.setMobileNumber(orderDto.getMobileNumber());
        order.setPincode(orderDto.getPincode());
        return order;
    }
}
