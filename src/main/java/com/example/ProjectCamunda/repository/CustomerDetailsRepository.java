package com.example.ProjectCamunda.repository;

import com.example.ProjectCamunda.dto.CustomerDetailsDto;
import com.example.ProjectCamunda.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long>{
    CustomerDetailsDto findByMobileNumber(String mobileNumber);
}
