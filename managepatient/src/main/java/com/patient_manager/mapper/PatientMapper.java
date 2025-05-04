package com.patient_manager.mapper;

import java.time.LocalDate;

import com.patient_manager.Entity.Patient;
import com.patient_manager.dto.PatientRequestDto;
import com.patient_manager.dto.PatientResponseDto;

public class PatientMapper {
	public static PatientResponseDto toDto(Patient patient) {
		PatientResponseDto patientDTO=new PatientResponseDto();
		patientDTO.setId(patient.getId().toString());
		patientDTO.setName(patient.getName());
		patientDTO.setEmail(patient.getEmail());
		patientDTO.setAddress(patient.getAddress());
		patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
		return patientDTO;
	}

	  public static Patient toModel(PatientRequestDto patientRequestDTO) {
	    Patient patient = new Patient();
	    patient.setName(patientRequestDTO.getName());
	    patient.setAddress(patientRequestDTO.getAddress());
	    patient.setEmail(patientRequestDTO.getEmail());
	    patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
	    
	    patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
	    return patient;
	  }

}
