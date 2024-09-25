package com.example.wellness_tracker_api.patient.model;

import com.example.wellness_tracker_api.domain.BaseDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "patients")
@EqualsAndHashCode(callSuper = true)
@Data
public class Patient extends BaseDocument {
    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String email;
}
