package com.hospitalmanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import com.hospitalmanagement.entity.type.BloodGroupType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ToString.Exclude
	private LocalDate birthDate;
	private String email;
	private String gender;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Enumerated(EnumType.STRING)
	private BloodGroupType bloodGroup;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	@JoinColumn
	private Insurance insurance;
	
	@OneToMany(mappedBy = "patient", cascade= {CascadeType.REMOVE}, orphanRemoval = true)
	private List<Appointment> appointments;
}
