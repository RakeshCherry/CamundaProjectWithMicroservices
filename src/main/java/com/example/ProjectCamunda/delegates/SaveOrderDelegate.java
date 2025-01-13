package com.example.ProjectCamunda.delegates;

import com.example.ProjectCamunda.dto.OrderDto;
import com.example.ProjectCamunda.entity.CustomerDetails;
import com.example.ProjectCamunda.entity.Order;
import com.example.ProjectCamunda.mapper.OrderMappar;
import com.example.ProjectCamunda.service.IOrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class SaveOrderDelegate implements JavaDelegate {

//    private final IOrderService orderService;
//
//    public SaveOrderDelegate(IOrderService orderService) {
//        this.orderService = orderService;
//    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long itemId = (Long) execution.getVariable("itemId");
        Map<String, Object> customerDetails = (Map<String, Object>) execution.getVariable("customerDetails");
        Integer noOfItems = (Integer) execution.getVariable("noOfItems");

        log.info("Order Details: Item ID: {}, Customer: {}, No of Items: {}", itemId, customerDetails, noOfItems);

        execution.setVariable("orderSaved", true);

        log.info("Order saved successfully");
    }
}