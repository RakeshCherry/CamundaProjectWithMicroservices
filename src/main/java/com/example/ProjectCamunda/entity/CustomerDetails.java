package com.example.ProjectCamunda.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class CustomerDetails {

    private String customerName;
    private String customerType;
    private String mobileNumber;
    private int pincode;


}
