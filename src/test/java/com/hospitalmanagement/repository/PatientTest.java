package com.hospitalmanagement.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospitalmanagement.entity.Patient;

@SpringBootTest
public class PatientTest {
	
	@Autowired
	private PatientRepository patientrepo;
	
	@Test
	public void testPatientRepository() {
		List<Patient> list = patientrepo.findAll();
		System.out.println(list);
	}

}
