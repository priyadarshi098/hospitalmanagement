package com.hospitalmanagement.dto;

import com.hospitalmanagement.entity.Appointment;
import com.hospitalmanagement.entity.Insurance;
import com.hospitalmanagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PatientDTO {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    private LocalDateTime createdAt;

    private BloodGroupType bloodGroup;

    private Insurance insurance;

    private List<Appointment> appointments;
}
