package com.example.ProjectCamunda.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    @NotBlank
    private String item;

    @NotNull
    @Min(1)
    private Integer noOfItems;

    @NotNull
    private CustomerDetailsDto customerDetails;
}
