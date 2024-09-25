package com.example.wellness_tracker_api.surgery.service;

import com.example.wellness_tracker_api.patient.model.Patient;
import com.example.wellness_tracker_api.patient.repository.PatientRepository;
import com.example.wellness_tracker_api.surgery.model.Surgery;
import com.example.wellness_tracker_api.surgery.reponsitory.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {
    @Autowired
    private SurgeryRepository surgeryRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Surgery createSurgery(Surgery surgery, String patientId){
        Optional<Patient> patient = patientRepository.findById(patientId);

        if(patient.isEmpty()){
            throw new IllegalStateException("Patient not found");
        }

        Surgery updatedSurgery = Surgery.builder()
                .patient(patient.orElse(null))
                .name(surgery.getName())
                .status(surgery.getStatus())
                .build();

        System.out.println(patient);
        System.out.println(patient);

        return surgeryRepository.save(updatedSurgery);
    }

    public List<Surgery> getAllSurgery(){
        return surgeryRepository.findAll();
    }


    public Surgery getSurgeryById(String surgeryId){
        return surgeryRepository.findById(surgeryId)
                .orElseThrow(() -> new IllegalStateException("Surgery Not Found"));
    }

    public Surgery updateSurgery(String surgeryId,Surgery updatedSurgery){
        Surgery foundSurgery  = surgeryRepository.findById(surgeryId).orElseThrow(() -> new IllegalStateException("Surgery Not Found"));

        foundSurgery.setName(updatedSurgery.getName());
        foundSurgery.setStatus(updatedSurgery.getStatus());

        return surgeryRepository.save(foundSurgery);
    }

    public String deleteSurgery(String surgeryId){
        if (surgeryRepository.existsById(surgeryId)) {
            surgeryRepository.deleteById(surgeryId);
            return "Deleted successfully";
        }else{
            return "Error could not delete surgery";
        }

    }
}
