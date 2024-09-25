package com.example.wellness_tracker_api.surgery.reponsitory;

import com.example.wellness_tracker_api.patient.model.Patient;
import com.example.wellness_tracker_api.surgery.model.Surgery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository  extends MongoRepository<Surgery,String> {


}
