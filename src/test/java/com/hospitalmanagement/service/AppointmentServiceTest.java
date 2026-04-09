package com.hospitalmanagement.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospitalmanagement.entity.Appointment;

@SpringBootTest
class AppointmentServiceTest {
	
	@Autowired
	private AppointmentService appointmentservice;
	

	@Test
	void test() {
		Appointment appointment = Appointment.builder()
				.appointmentTime(LocalDateTime.of(2026,11,01,14,0,0))
				.reason("cancer")
				.build();
		
		Appointment appoint = appointmentservice.createNewAppointment(appointment, 1L, 2L);
		
		System.out.println(appoint);
	}

}
