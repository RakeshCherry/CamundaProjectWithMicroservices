package com.example.ProjectCamunda.controller;

import com.example.ProjectCamunda.Validator.OrderValidator;
import com.example.ProjectCamunda.constants.OrderConstants;
import com.example.ProjectCamunda.dto.ResponseDto;
import com.example.ProjectCamunda.entity.CustomerDetails;
import com.example.ProjectCamunda.entity.Order;
import com.example.ProjectCamunda.service.IOrderService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RuntimeService runtimeService;
    private final IOrderService iOrderService;

    // Constructor injection for RuntimeService and IOrderService
    public OrderController(RuntimeService runtimeService, IOrderService iOrderService) {
        this.runtimeService = runtimeService;
        this.iOrderService = iOrderService;
    }

    @PostMapping("/process")
    public ResponseEntity<ResponseDto> startOrderProcess(@RequestBody Map<String, Object> payload) {

        OrderValidator.validatePayload(payload);

        // Extract variables from the payload
        Long itemId = Long.valueOf(payload.get("itemId").toString());
        Map<String, Object> customerDetailsMap = (Map<String, Object>) payload.get("customerDetails");
        Integer noOfItems = Integer.valueOf(payload.get("noOfItems").toString());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
                "order_process_execute",  // Camunda process key
                Map.of(
                        "itemId", itemId,
                        "customerDetails", customerDetailsMap,
                        "noOfItems", noOfItems
                )
        );

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerName(customerDetailsMap.get("customerName").toString());
        customerDetails.setCustomerType(customerDetailsMap.get("customerType").toString());
        customerDetails.setMobileNumber(customerDetailsMap.get("mobileNumber").toString());
        customerDetails.setPincode((Integer) customerDetailsMap.get("pincode"));

        Order order = new Order();
        order.setItemId(itemId);
        order.setCustomerDetails(customerDetails);
        order.setNoOfItems(noOfItems);

        iOrderService.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(OrderConstants.STATUS_201, "Order created and process started with ID: " + processInstance.getId()));
    }
}
