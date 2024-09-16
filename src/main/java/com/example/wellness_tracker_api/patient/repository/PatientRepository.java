package com.example.wellness_tracker_api.patient.repository;
import org.springframework.data.mongodb.repository.Query;
import com.example.wellness_tracker_api.patient.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient,Long> {
    Optional<Patient> findById(String id);

    @Query("{ '$or': [ { 'firstName': ?0 }, { 'lastName': ?1 } ] }")
    List<Patient> findByNameField(String firstName, String lastName);

    Optional<Patient> deleteById(String id);

}