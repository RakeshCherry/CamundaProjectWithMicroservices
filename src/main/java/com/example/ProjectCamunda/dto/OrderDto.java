package com.example.ProjectCamunda.dto;

import com.example.ProjectCamunda.entity.CustomerDetails;
import com.fasterxml.classmate.AnnotationOverrides;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long itemId;

    private CustomerDetails customerDetails;

    private int noOfItems;
}
