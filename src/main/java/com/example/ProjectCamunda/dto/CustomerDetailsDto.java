package com.example.ProjectCamunda.dto;

import com.example.ProjectCamunda.entity.CustomerDetails;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDetailsDto {

    @NotNull
    private Integer pincode;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String customerName;

    @NotBlank
    private String customerType;

}
