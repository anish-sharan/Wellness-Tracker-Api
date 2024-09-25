package com.example.wellness_tracker_api.surgery.controller;

import com.example.wellness_tracker_api.surgery.model.Surgery;
import com.example.wellness_tracker_api.surgery.service.SurgeryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/v1/surgery")
public class SurgeryController {
    @Autowired
    private SurgeryService surgeryService;

    @Operation(summary = "Create surgery", description = "create surgery for the patient")
    @PostMapping("patient/{patientId}")
    public Surgery createSurgery(@PathVariable("patientId") String patientId, @RequestBody Surgery surgery){
        return new ResponseEntity<>(surgeryService.createSurgery(surgery, patientId), HttpStatus.CREATED).getBody();
    }

    @Operation(summary = "Get all surgery", description = "Fetch all surgeries")
    @GetMapping
    public List<Surgery> getAllSurgeries(){
        return new ResponseEntity<>(surgeryService.getAllSurgery(), HttpStatus.OK).getBody();
    };

    @Operation(summary = "Get surgery by id", description = "Get surgery by id")
    @GetMapping("{surgeryId}")
    public Surgery getSurgeryById(@PathVariable("surgeryId") String surgeryId){
        return new ResponseEntity<>(surgeryService.getSurgeryById(surgeryId), HttpStatus.OK).getBody();
    }

    @Operation(summary = "Patch surgery by id", description = "Patch surgery by id")
    @PatchMapping("{surgeryId}")
    public Surgery updateSurgery(@PathVariable("surgeryId") String surgeryId, @RequestBody Surgery updatedSurgery){
        return new ResponseEntity<>(surgeryService.updateSurgery(surgeryId,updatedSurgery), HttpStatus.OK).getBody();
    }

    @Operation(summary = "Delete surgery", description = "Delete surgery")
    @DeleteMapping("{surgeryId}")
    public String deleteSurgery(@PathVariable("surgeryId") String surgeryId){
        return new ResponseEntity<>(surgeryService.deleteSurgery(surgeryId),HttpStatus.ACCEPTED).getBody();
    }
}
