package com.example.wellness_tracker_api.surgery.model;

import com.example.wellness_tracker_api.domain.BaseDocument;
import com.example.wellness_tracker_api.patient.model.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Document(collection = "surgery")
public class Surgery extends BaseDocument {
    @DBRef(lazy = true)
    private Patient patient;

    private String name;

    private SurgeryStatus status;


}
