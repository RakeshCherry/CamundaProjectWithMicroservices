package com.example.ProjectCamunda.repository;

import com.example.ProjectCamunda.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}