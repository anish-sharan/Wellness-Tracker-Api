package com.example.wellness_tracker_api.patient.controller;

import com.example.wellness_tracker_api.patient.model.Patient;
import com.example.wellness_tracker_api.patient.service.PatientService;
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

    @PostMapping
    private Patient createPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED).getBody();
    }

    @GetMapping
    private List<Patient> getPatient(){
        return new ArrayList<>(patientService.getPatient());
    }

    @GetMapping("/{patientId}")
    private Optional<Patient> getPatientById(@PathVariable("patientId") String patientId){
        return patientService.getPatientById(patientId);
    }

    @GetMapping("/search")
    public List<Patient> searchPatientByField(@RequestParam(required = false) String firstName,
                                              @RequestParam(required = false) String lastName) {
        return patientService.searchPatientByField(firstName, lastName);
    }

    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable("patientId") String patientId, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(patientId,updatedPatient);
    }

    @DeleteMapping("/{patientId}")
    public Optional<Patient> deletePatient(@PathVariable("patientId") String patientId){
        return patientService.deletePatient(patientId);
    }

}
