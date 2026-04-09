package com.hospitalmanagement.service;


import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospitalmanagement.entity.Insurance;

@SpringBootTest
class InsuranceServiceTest {
	
	@Autowired
	private InsuranceService insuranceservice;

	@Test
	public void assignInsuranceToPatient_test() {
		
		insuranceservice.assignInsuranceToPatient(
				Insurance.builder()
				.policyNumber("Hdfc_1234")
				.provider("HDFC")
				.validUntil(LocalDate.of(2030, 01, 01))
				.build(), 5L);
	}

	
	@Test
	public void removeInsurance_test() {
		
		insuranceservice.removeInsuranceFromPatient(2L);
	}
}
