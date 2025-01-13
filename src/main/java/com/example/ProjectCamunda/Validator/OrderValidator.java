package com.example.ProjectCamunda.Validator;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

public class OrderValidator {

    public static void validatePayload(Map<String, Object> payload) {
        // Validate itemId
        if (!payload.containsKey("itemId") || payload.get("itemId") == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item ID is required");
        }
        try {
            Long.valueOf(payload.get("itemId").toString());
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item ID must be a valid number");
        }

        // Validate customerDetails
        if (!payload.containsKey("customerDetails") || payload.get("customerDetails") == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer details are required");
        }
        Map<String, Object> customerDetails = (Map<String, Object>) payload.get("customerDetails");
        validateCustomerDetails(customerDetails);

        // Validate noOfItems
        if (!payload.containsKey("noOfItems") || payload.get("noOfItems") == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Number of items is required");
        }
        try {
            int noOfItems = Integer.parseInt(payload.get("noOfItems").toString());
            if (noOfItems <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Number of items must be greater than 0");
            }
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Number of items must be a valid integer");
        }
    }

    private static void validateCustomerDetails(Map<String, Object> customerDetails) {
        if (!customerDetails.containsKey("customerName") || customerDetails.get("customerName") == null || customerDetails.get("customerName").toString().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer name is required");
        }
        if (!customerDetails.containsKey("customerType") || customerDetails.get("customerType") == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer type is required");
        }
        String customerType = customerDetails.get("customerType").toString();
        if (!customerType.equals("VIP") && !customerType.equals("Regular")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer type must be either VIP or Regular");
        }
        if (!customerDetails.containsKey("mobileNumber") || customerDetails.get("mobileNumber") == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mobile number is required");
        }
        String mobileNumber = customerDetails.get("mobileNumber").toString();
        if (!mobileNumber.matches("^\\d{10}$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mobile number must be a valid 10-digit number");
        }
        if (!customerDetails.containsKey("pincode") || customerDetails.get("pincode") == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pincode is required");
        }
        try {
            int pincode = Integer.parseInt(customerDetails.get("pincode").toString());
            if (String.valueOf(pincode).length() != 6) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pincode must be a 6-digit number");
            }
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pincode must be a valid 6-digit number");
        }
    }
}

