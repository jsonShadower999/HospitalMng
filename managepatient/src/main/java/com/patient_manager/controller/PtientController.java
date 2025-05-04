package com.patient_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient_manager.dto.PatientRequestDto;
import com.patient_manager.dto.PatientResponseDto;
import com.patient_manager.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PtientController {
	@Autowired
	private  PatientService patientservice;
	
	@GetMapping
	public ResponseEntity<List<PatientResponseDto>> getpatients(){
		List<PatientResponseDto> patients= patientservice.getPatients();
		return ResponseEntity.ok().body(patients);
	}
	@PostMapping 
	public  ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDTO) {
		 System.out.println("data recive 1"+ patientRequestDTO.getRegisteredDate());
		 PatientResponseDto patient_response= patientservice.createPatient( patientRequestDTO);
		 return ResponseEntity.ok().body(patient_response);
	}
	

}
