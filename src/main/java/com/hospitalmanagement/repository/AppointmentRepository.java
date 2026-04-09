package com.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
