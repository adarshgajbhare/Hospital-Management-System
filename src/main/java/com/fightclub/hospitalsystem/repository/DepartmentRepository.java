package com.fightclub.hospitalsystem.repository;

import com.fightclub.hospitalsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
}