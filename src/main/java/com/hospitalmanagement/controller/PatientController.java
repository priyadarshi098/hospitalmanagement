package com.hospitalmanagement.controller;

import com.hospitalmanagement.dto.InsuranceDTO;
import com.hospitalmanagement.dto.PatientDTO;
import com.hospitalmanagement.entity.Insurance;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.service.PateintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PateintService patientservice;

    @GetMapping(value = "/patients", produces = "Application/json")

    public List<Patient> getAllPatients(){
        System.out.println("000000000000000000000000000000000000000000000000000000000000");
        return patientservice.getAllPatients();
    }

    @PostMapping(
            value = "/addins/{patientId}",
            consumes = "Application/json")
    public PatientDTO addInsuranceToPatient(
            @RequestBody InsuranceDTO insurancedto,
            @PathVariable Long patientId){
        return patientservice.assignInsuranceToPatient(
                insurancedto,
                patientId);
    }
}
