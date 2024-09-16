package com.example.wellness_tracker_api.patient.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PatientUpdateDTO {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
}
