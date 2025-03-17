package org.example.activite_pratique_n_3;

import org.example.activite_pratique_n_3.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContaining(String keyword);
}
