package com.fightclub.hospitalsystem.entity;

import com.fightclub.hospitalsystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

@Autowired
    private PatientRepository repository;

    @Test
    public void testFindAllPatient() {
        List<Patient> patientList = repository.findAll();
        System.out.println(patientList);
    }

    @Test
    void testFindById() {
        Patient patientList = repository.findById(1L).orElse(null);
        System.out.println(patientList);
    }

    @Test
    public void testFindByEmail() {
        Patient patient
                 = repository.findByEmail("simran.kaur@example.com");
        System.out.println(patient);
    }

    @Test
    public void testFindByName(){
        Patient patient
                = repository.findByName("Simran Kaur");
        System.out.println(patient);
    }

    @Test
    public void testFindByBloodGroup(){
        List<Patient> patientList
                = repository.findByBloodGroup();
        System.out.println(patientList);
    }
}

