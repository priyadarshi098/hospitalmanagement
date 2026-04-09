package com.hospitalmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.entity.type.BloodGroupType;
import com.hospitalmanagement.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PateintService {
	
	
	private final PatientRepository patientrepository;
	
	@Transactional
	public Patient getPatientById(String name) {
//		Patient p1 = patientrepository.findById(id).orElseThrow();
//		Patient p2 = patientrepository.findById(id).orElseThrow();
//		p1.setName("yuyu");
		
		Patient p3 = patientrepository.findByName(name);
		return p3;
		
	}
	
	public List<Patient> getPatientByBirthDate(LocalDate birthdate, String name) {
		
		List<Patient> p1 = patientrepository.findByBirthDateOrName(birthdate,name);
		return p1;
		
	}
	
	public List<Object[]> getBloodGroupCount(){
		
		List<Object[]> bloodgroupcount = patientrepository.getBloodGroupCount();
		return bloodgroupcount;
	}
	
	public List<Patient> getAllPatients(){
		List<Patient> lst = patientrepository.findAllPetient();
		return lst;
	}
	

}
