package com.fightclub.hospitalsystem.entity;

import jakarta.persistence.*;
import lombok.*;
;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dob;
    private String address;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @OneToOne(cascade = {CascadeType.ALL  }, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;


    @OneToMany(mappedBy = "patient" , cascade = {CascadeType.REMOVE} , orphanRemoval = true)
    @ToString.Exclude
    List<Appointment> appointments = new ArrayList<>();
}
