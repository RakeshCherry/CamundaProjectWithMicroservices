package com.example.ProjectCamunda.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String item;

    private int noOfItems;

    private String CustomerName;

    private String CustomerType;

    private String MobileNumber;

    private int Pincode;

    private CustomerDetailsDto customerDetails;


}
