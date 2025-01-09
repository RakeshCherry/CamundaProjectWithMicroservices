package com.example.ProjectCamunda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;

@SpringBootApplication
public class ProjectCamundaApplication {

  public static void main(String... args) {
    SpringApplication.run(ProjectCamundaApplication.class, args);
  }
}