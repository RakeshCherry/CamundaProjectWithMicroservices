package com.example.ProjectCamunda.service.impl;

import com.example.ProjectCamunda.dto.CustomerDetailsDto;
import com.example.ProjectCamunda.entity.CustomerDetails;
import com.example.ProjectCamunda.exception.ResourceNotFoundException;
import com.example.ProjectCamunda.mapper.CustomerDetailsMapper;
import com.example.ProjectCamunda.repository.CustomerDetailsRepository;
import com.example.ProjectCamunda.service.ICustomerDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerDetailsImpl implements ICustomerDetailsService {

    private CustomerDetailsRepository customerDetailsRepository;

    @Override
    public void createCustomerDetails(CustomerDetailsDto customerDetailsDto) {

        customerDetailsRepository.save(CustomerDetailsMapper.mapToCustomerDetails(customerDetailsDto, new CustomerDetails()));
    }

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        CustomerDetailsDto customerDetails = customerDetailsRepository.findByMobileNumber(mobileNumber);

        if (customerDetails == null) {
            throw new ResourceNotFoundException("Customer not found");
        }

        return customerDetails;
    }
}
