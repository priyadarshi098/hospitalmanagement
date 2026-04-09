package com.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
