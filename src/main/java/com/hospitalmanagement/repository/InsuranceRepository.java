package com.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long>{

}
