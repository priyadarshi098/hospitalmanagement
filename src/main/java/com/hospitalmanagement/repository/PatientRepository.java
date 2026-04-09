package com.hospitalmanagement.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	Patient findByName(String name);

	Patient findByBirthDate(LocalDate birthdate);

	@Query("select p from Patient p where p.birthDate=?1 or p.name=?2")
	List<Patient> findByBirthDateOrName(@Param("birthdate") LocalDate birthdate, @Param("name") String name);

	@Query("select p.bloodGroup,count(p) from Patient p group By p.bloodGroup")
	List<Object[]> getBloodGroupCount();
	
	@Query(value = "select * from patient", nativeQuery=true)
	List<Patient> findAllPetient();

	

}
