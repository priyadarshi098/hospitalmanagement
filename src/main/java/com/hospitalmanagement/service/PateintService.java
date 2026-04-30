package com.hospitalmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.hospitalmanagement.dto.DoctorDTO;
import com.hospitalmanagement.dto.InsuranceDTO;
import com.hospitalmanagement.dto.PatientDTO;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.entity.Insurance;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
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

	public PatientDTO assignInsuranceToPatient(
			InsuranceDTO insurancedto,
			Long patientId) {
		System.out.println("insurance===============service called");
		Patient patient = patientrepository
				.findById(patientId)
				.orElseThrow(() -> new EntityNotFoundException("patient not found with id : "+patientId));
		System.out.println("insurance==============="+insurancedto);
		System.out.println("patient==============="+patient);
		Insurance insurance = convertClassType(insurancedto, Insurance.class);
		patient.setInsurance(insurance);
		insurance.setPatient(patient);
        return convertClassType(patient, PatientDTO.class);


	}

//	private PatientDTO convertToDTO(Patient patient){
//		PatientDTO patientdto = new PatientDTO();
//		BeanUtils.copyProperties(patient,patientdto);
//		System.out.println("9999999999999=============00000000000000"+patientdto);
//		return patientdto;
//	}

	private <S, T> T convertClassType(S source, Class<T> targetClass) {
		try {
			T target = targetClass.getDeclaredConstructor().newInstance();
			BeanUtils.copyProperties(source, target);
			return target;
		} catch (Exception e) {
			throw new RuntimeException("Error while converting object", e);
		}
	}

}
