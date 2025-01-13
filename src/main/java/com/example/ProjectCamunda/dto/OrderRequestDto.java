package com.example.ProjectCamunda.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    @NotNull(message = "Item ID is required")
    private Long itemId;

    @Valid
    @NotNull(message = "Customer details are required")
    private CustomerDetailsDto customerDetails;

    @NotNull(message = "Number of items is required")
    @Min(value = 1, message = "Number of items must be at least 1")
    private Integer noOfItems;


    public static class CustomerDetailsDto {
        @NotBlank(message = "Customer name is required")
        private String customerName;

        @NotBlank(message = "Customer type is required")
        @Pattern(regexp = "VIP|Regular", message = "Customer type must be either VIP or Regular")
        private String customerType;

        @NotBlank(message = "Mobile number is required")
        @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
        private String mobileNumber;

        @NotNull(message = "Pincode is required")
        @Digits(integer = 6, fraction = 0, message = "Pincode must be a 6-digit number")
        private Integer pincode;
    }
}

