package com.example.wellness_tracker_api.patient.service;

import com.example.wellness_tracker_api.patient.model.Patient;
import com.example.wellness_tracker_api.patient.model.PatientUpdateDTO;
import com.example.wellness_tracker_api.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<Patient> getPatientById(String patientId) {
        return patientRepository.findById(patientId);
    }

    public  List<Patient> searchPatientByField(String firstName, String lastName) {
        return patientRepository.findByNameField(firstName,lastName);
    }

    public  Patient updatePatient(String patientId,Patient patientToUpdate) {
        Optional<Patient> selectedPatient = patientRepository.findById(patientId);

        if (selectedPatient.isPresent()) {
            Patient patient = selectedPatient.get();
            patient.setFirstName(patientToUpdate.getFirstName());
            patient.setLastName(patientToUpdate.getLastName());
            return patientRepository.save(patient);
        } else {
            throw new RuntimeException("Patient not found with ID: " + patientId);
        }
    }

    public Optional<Patient> deletePatient(String patientId) {
        return patientRepository.deleteById(patientId);
    }

}
