package com.example.ProjectCamunda.controller;

import com.example.ProjectCamunda.constants.InventoryConstants;
import com.example.ProjectCamunda.dto.InventoryDto;
import com.example.ProjectCamunda.dto.ResponseDto;
import com.example.ProjectCamunda.service.IInventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {

    private IInventoryService iInventoryService;

    @PostMapping("/process")
    public ResponseEntity<ResponseDto> createInventory(@RequestBody InventoryDto inventoryDto) {

        iInventoryService.createInventory(inventoryDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(InventoryConstants.STATUS_201, InventoryConstants.MESSAGE_201));
    }
}
