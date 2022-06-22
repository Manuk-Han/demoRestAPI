package com.demoRestAPI.account.Repository;

import com.demoRestAPI.account.Entity.Nurse;
import com.demoRestAPI.account.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findPatientById(Long patientId);

}
