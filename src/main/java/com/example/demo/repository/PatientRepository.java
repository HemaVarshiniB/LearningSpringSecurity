package com.example.demo.repository;

import com.example.demo.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "select * from PATIENT", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);
}
