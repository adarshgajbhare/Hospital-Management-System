package com.fightclub.hospitalsystem.service;

import com.fightclub.hospitalsystem.entity.Appointment;
import com.fightclub.hospitalsystem.entity.Doctor;
import com.fightclub.hospitalsystem.entity.Patient;
import com.fightclub.hospitalsystem.repository.AppointmentRepository;
import com.fightclub.hospitalsystem.repository.DoctorRepository;
import com.fightclub.hospitalsystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment creteAppointment(Appointment appointment, Long patientId, Long doctorId) {

        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));

        if (appointment.getId() != null) throw new IllegalArgumentException("Appointment id should not have been set");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointments().add(appointment);

        appointmentRepository.save(appointment);
        return appointment;
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentID, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentID)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + appointmentID));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));

        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);
        return appointment;
    }
}
