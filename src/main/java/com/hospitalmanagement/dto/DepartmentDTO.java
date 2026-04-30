package com.hospitalmanagement.dto;
import java.util.List;

public class DepartmentDTO {

    private Long id;

    private String name;

    private DoctorDTO headDoctor;

    private List<DoctorDTO> doctors;
}
