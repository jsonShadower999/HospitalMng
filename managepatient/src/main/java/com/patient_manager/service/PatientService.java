package com.patient_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient_manager.Entity.Patient;
import com.patient_manager.dto.PatientRequestDto;
import com.patient_manager.dto.PatientResponseDto;
import com.patient_manager.exception.EmailAlreadyExistsException;
import com.patient_manager.mapper.PatientMapper;
import com.patient_manager.repo.PatientRepo;
@Service
public class PatientService {
	@Autowired
	private PatientRepo patientrepo;
	
	
	//get all patient sevice will return dto to controller
	public List<PatientResponseDto> getPatients(){
		List<Patient> patients=patientrepo.findAll();
		List<PatientResponseDto> patientresponses=patients.stream().map(PatientMapper::toDto).toList();
		return patientresponses;
	}
	 public PatientResponseDto createPatient(PatientRequestDto patientRequestDTO) {
		    if (patientrepo.existsByEmail(patientRequestDTO.getEmail())) {
		      throw new EmailAlreadyExistsException(
		          "A patient with this email " + "already exists"
		              + patientRequestDTO.getEmail());
		    }
         System.out.println(patientRequestDTO.getRegisteredDate());
		    Patient newPatient = patientrepo.save(
		        PatientMapper.toModel(patientRequestDTO));
		    System.out.println("recive 2..."+ newPatient);
//
//		    billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString(),
//		        newPatient.getName(), newPatient.getEmail());
//
//		    kafkaProducer.sendEvent(newPatient);

		    return PatientMapper.toDto(newPatient);
		  }


}
