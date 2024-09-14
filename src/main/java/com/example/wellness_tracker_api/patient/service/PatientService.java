package com.example.wellness_tracker_api.patient.service;

import com.example.wellness_tracker_api.patient.model.Patient;
import com.example.wellness_tracker_api.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public List<Patient> getPatient(){
        return patientRepository.findAll();
    }
}
