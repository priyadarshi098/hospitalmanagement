package com.hospitalmanagement.service;

import com.hospitalmanagement.dto.DoctorDTO;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tools.jackson.databind.util.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorrepository;

    public List<DoctorDTO> findAllDoctors(){
        List<Doctor> listdoctors = doctorrepository.findAll();
        System.out.println("===========dddddddddddd"+listdoctors);
        return listdoctors.stream()
        .map(this::convertToDTO).collect(Collectors.toList());
    }

    private DoctorDTO convertToDTO(Doctor doctor){
        DoctorDTO doctordto = new DoctorDTO();
        BeanUtils.copyProperties(doctor,doctordto);
        System.out.println("9999999999999=============00000000000000"+doctordto);
        return doctordto;
    }
}
