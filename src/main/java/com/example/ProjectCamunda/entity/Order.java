package com.example.ProjectCamunda.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long itemId;

    @Embedded
    private CustomerDetails customerDetails;

    private int noOfItems;

    public Order(Long itemId, Integer noOfItems) {
    }
}
