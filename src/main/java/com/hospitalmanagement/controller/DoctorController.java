package com.hospitalmanagement.controller;

import com.hospitalmanagement.dto.DoctorDTO;
import com.hospitalmanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorservice;

    @GetMapping("/doctors")
    public List<DoctorDTO> findAllDoctors(){
        return doctorservice.findAllDoctors();
    }
}
