package com.fightclub.hospitalsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patientdb")
public class Patient {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dob;
    private String gender;
    private String address;
    @Column(unique = true)
    private String email;
    private String bloodGroup;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

}
