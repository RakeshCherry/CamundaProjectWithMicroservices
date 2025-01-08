package com.example.ProjectCamunda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "item")
    private String item;

    @Column(name = "no_of_items")
    private int noOfItems;

    @Column(name = "customer_name")
    private String CustomerName;

    @Column(name = "customer_type")
    private String CustomerType;

    @Column(name = "mobile_number")
    private String MobileNumber;

    private int Pincode;

}
