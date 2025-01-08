package com.example.ProjectCamunda.mapper;

import com.example.ProjectCamunda.dto.CustomerDetailsDto;
import com.example.ProjectCamunda.entity.CustomerDetails;

public class CustomerDetailsMapper {

    public static CustomerDetailsDto mapToCustomerDetailsDto(CustomerDetails customerDetails, CustomerDetailsDto customerDetailsDto) {
        customerDetailsDto.setMobileNumber(customerDetails.getMobileNumber());
        customerDetailsDto.setCustomerName(customerDetails.getCustomerName());
        customerDetailsDto.setCustomerType(customerDetails.getCustomerType());
        customerDetailsDto.setPincode(customerDetails.getPincode());
        return customerDetailsDto;
    }

    public static CustomerDetails mapToCustomerDetails(CustomerDetailsDto customerDetailsDto, CustomerDetails customerDetails) {
        customerDetails.setMobileNumber(customerDetailsDto.getMobileNumber());
        customerDetails.setCustomerName(customerDetailsDto.getCustomerName());
        customerDetails.setCustomerType(customerDetailsDto.getCustomerType());
        customerDetails.setPincode(customerDetailsDto.getPincode());
        return customerDetails;
    }
}
