package com.example.ProjectCamunda.controller;

import com.example.ProjectCamunda.constants.InventoryConstants;
import com.example.ProjectCamunda.constants.OrderConstants;
import com.example.ProjectCamunda.dto.InventoryDto;
import com.example.ProjectCamunda.dto.OrderDto;
import com.example.ProjectCamunda.dto.ResponseDto;
import com.example.ProjectCamunda.service.IInventoryService;
import com.example.ProjectCamunda.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private IOrderService iOrderService;
    private IInventoryService iInventoryService;

    @PostMapping("/process")
    public ResponseEntity<ResponseDto> createOrder(@RequestBody OrderDto orderDto) {

        iOrderService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(OrderConstants.STATUS_201, OrderConstants.MESSAGE_201));
    }
}
