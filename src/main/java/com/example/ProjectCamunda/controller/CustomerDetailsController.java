//package com.example.ProjectCamunda.controller;
//
//
//import com.example.ProjectCamunda.dto.CustomerDetailsDto;
//import com.example.ProjectCamunda.service.ICustomerDetailsService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/customerDetails")
//public class CustomerDetailsController {
//
//    private ICustomerDetailsService iCustomerDetailsService;
//
//    @GetMapping("/fetchCustomerDetails")
//    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam String mobileNumber) {
//
//        CustomerDetailsDto customerDetailsDto = iCustomerDetailsService.fetchCustomerDetails(mobileNumber);
//
//        if (customerDetailsDto == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(customerDetailsDto);
//    }
//}
