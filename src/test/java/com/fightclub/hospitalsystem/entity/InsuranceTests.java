package com.fightclub.hospitalsystem.entity;


import com.fightclub.hospitalsystem.service.AppointmentService;
import com.fightclub.hospitalsystem.service.InsuranceService;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;

    @Test
     void testFindAllInsurance() {
        Insurance insurance
                = Insurance.builder()
                .policyNumber("POL-" + java.util.UUID.randomUUID().toString().substring(0,8))
                .provider("HealthSecure")
                .validUntil(java.time.LocalDate.of(2030, 12, 11))
                .build();

        Patient patient
                = insuranceService.assignInsuranceToPatient(insurance, 4L);
        System.out.println(patient);


        var removedPatient = insuranceService.disaccordPatientFromInsurance(patient.getId());
        System.out.println(removedPatient);


    }


     @Test
     void creteAppointment(){
         Appointment appointment = Appointment.builder()
                 .appointmentDate(java.time.LocalDate.of(2024, 7, 20))
                 .reason("Regular Checkup")
                 .build();

         Appointment cretedAppointment = appointmentService.creteAppointment(appointment, 4L, 2L);

         System.out.println(cretedAppointment);

         Appointment reAssignAppointmentToAnotherDoctor = appointmentService.reAssignAppointmentToAnotherDoctor(cretedAppointment.getId(), 3L);
         System.out.println(reAssignAppointmentToAnotherDoctor);

     }























}
