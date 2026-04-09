package com.hospitalmanagement.service;

import org.springframework.stereotype.Service;

import com.hospitalmanagement.entity.Appointment;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.repository.AppointmentRepository;
import com.hospitalmanagement.repository.DoctorRepository;
import com.hospitalmanagement.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	
	private final AppointmentRepository appointmentrepository;
	private final DoctorRepository doctorrepository;
	private final PatientRepository patientrepository;
	
	@Transactional
	public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
		Doctor doctor = doctorrepository.findById(doctorId).orElseThrow();
		Patient patient = patientrepository.findById(patientId).orElseThrow();
		
		if(appointment.getId() != null) {
			throw new IllegalArgumentException("appointment is already created");
			
		}
		
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		patient.getAppointments().add(appointment);
		
		return appointmentrepository.save(appointment);
	}

}
