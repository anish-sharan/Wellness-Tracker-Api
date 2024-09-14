package com.example.wellness_tracker_api.patient.controller;

import com.example.wellness_tracker_api.patient.model.Patient;
import com.example.wellness_tracker_api.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    private Patient createPatient(@Valid @RequestBody Patient patient){
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED).getBody();
    }

    @GetMapping
    private List<Patient> getPatient(){
        return new ArrayList<>(patientService.getPatient());
    }

}
