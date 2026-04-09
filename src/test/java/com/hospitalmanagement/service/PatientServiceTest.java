package com.hospitalmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospitalmanagement.entity.Patient;

@SpringBootTest
public class PatientServiceTest {
	
	@Autowired
	private PateintService patientservice;
	
	@Test
	public void findPatientByIdTest(){
		
		Patient p1 = patientservice.getPatientById("User90");
		System.out.println(p1);
	}
	
	@Test
	public void findPatientByDobTest() {
		List<Patient> p1 = patientservice.getPatientByBirthDate(LocalDate.of(1992,10,23),"User100");
		System.out.println(p1);
		
		List<Object[]> map1 = patientservice.getBloodGroupCount();
		System.out.println("=================================================================="+map1);
		map1.forEach(obj -> System.out.println(obj[0] +"  " +obj[1]));
		
		List<Patient> lst = patientservice.getAllPatients();
		lst.forEach(e -> System.out.println(e));
	}
	

}
