package com.hospitalmanagement.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentDTO {

    private Long id;

    private LocalDateTime appointmentTime;

    private String reason;

    private PatientDTO patient;

    private DoctorDTO doctor;
}
