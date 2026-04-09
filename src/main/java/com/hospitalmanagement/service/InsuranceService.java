package com.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.entity.Insurance;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.repository.InsuranceRepository;
import com.hospitalmanagement.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class InsuranceService {
	
	private InsuranceRepository insurancerepository;
	
	@Autowired
	private PatientRepository patientrepository;
	
	@Transactional
	public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
		System.out.println("insurance===============service called");
		Patient patient = patientrepository
				.findById(patientId)
				.orElseThrow(() -> new EntityNotFoundException("patient not found with id : "+patientId));
		System.out.println("insurance==============="+insurance);
		System.out.println("patient==============="+patient);
		patient.setInsurance(insurance);
		insurance.setPatient(patient);
		
		return patient;
		
		
	}
	
	@Transactional
	public Patient removeInsuranceFromPatient(Long patientId) {
		Patient patient = patientrepository.findById(patientId).orElseThrow();
		patient.setInsurance(null);
		System.out.println("patient===============detached");
		return patient;
	}

}
