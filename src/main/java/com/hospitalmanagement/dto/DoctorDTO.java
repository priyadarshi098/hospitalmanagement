package com.hospitalmanagement.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class DoctorDTO {

    private Long id;

    private String name;

    private String specialization;

    private List<DepartmentDTO> departments;

    private List<AppointmentDTO> appointments;
}
