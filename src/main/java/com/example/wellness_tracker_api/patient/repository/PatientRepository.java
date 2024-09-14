package com.example.wellness_tracker_api.patient.repository;
import com.example.wellness_tracker_api.patient.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient,Long> {}