package com.example.ProjectCamunda.delegates;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DummyApiPostCallDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        log.info("Executing DummyApiPostCallDelegate");

        // Simulating the request body
        String requestBody = "{}";
        log.info("Request Body: {}", requestBody);

        // Simulating the API response
        String simulatedResponse = "{ \"message\": \"success\" }";
        log.info("Simulated Response from API: {}", simulatedResponse);

        log.info("DummyApiPostCallDelegate executed successfully");
    }
}
