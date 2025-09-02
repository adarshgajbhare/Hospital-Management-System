package com.fightclub.hospitalsystem.service;

import com.fightclub.hospitalsystem.entity.Insurance;
import com.fightclub.hospitalsystem.entity.Patient;
import com.fightclub.hospitalsystem.repository.InsuranceRepository;
import com.fightclub.hospitalsystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;


    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {

        Patient patient = patientRepository.findById(patientId).orElseThrow(() ->
                new RuntimeException("Patient not found with id: " + patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;

    }

    public Patient disaccordPatientFromInsurance(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() ->
                new RuntimeException("Patient not found with id: " + patientId));
        patient.setInsurance(null);
        return patient;
    }
}
