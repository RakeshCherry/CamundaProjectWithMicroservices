package com.example.ProjectCamunda.dto;

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
    private String name;

    @NotBlank
    private String customerType;
}
