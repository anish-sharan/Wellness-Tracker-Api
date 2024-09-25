package com.example.wellness_tracker_api.patient.controller;

import com.example.wellness_tracker_api.patient.model.Patient;
import com.example.wellness_tracker_api.patient.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Operation(
            summary = "Creates a patient",
            description = "Creates patient")
    @PostMapping
    private Patient createPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED).getBody();
    }

    @Operation(
            summary = "Get a patient",
            description = "Get patient")
    @GetMapping
    private List<Patient> getPatient(){
        return new ArrayList<>(patientService.getPatient());
    }

    @Operation(
            summary = "Get a patient by id",
            description = "Get patient by id")
    @GetMapping("/{patientId}")
    private Optional<Patient> getPatientById(@PathVariable("patientId") String patientId){
        return patientService.getPatientById(patientId);
    }

    @Operation(
            summary = "Returns patient by first name and last name",
            description = "Returns patient by first name and last name")
    @GetMapping("/search")
    public List<Patient> searchPatientByField(@RequestParam(required = false) String firstName,
                                              @RequestParam(required = false) String lastName) {
        return patientService.searchPatientByField(firstName, lastName);
    }

    @Operation(
            summary = "Update patient",
            description = "Update patient by id")
    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable("patientId") String patientId, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(patientId,updatedPatient);
    }

    @Operation(
            summary = "Delete patient by id",
            description = "Delete patient by id")
    @DeleteMapping("/{patientId}")
    public Optional<Patient> deletePatient(@PathVariable("patientId") String patientId){
        return patientService.deletePatient(patientId);
    }

}
