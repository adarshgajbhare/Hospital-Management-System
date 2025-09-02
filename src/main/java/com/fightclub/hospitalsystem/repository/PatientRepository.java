package com.fightclub.hospitalsystem.repository;

import com.fightclub.hospitalsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    Patient findByEmail(String email);


    Patient findByName(String name);

    @Query("select  p from Patient p where p.bloodGroup = 'O_POSITIVE'")
   List<Patient> findByBloodGroup();
}
