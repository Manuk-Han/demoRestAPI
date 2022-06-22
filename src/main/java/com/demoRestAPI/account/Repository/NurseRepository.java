package com.demoRestAPI.account.Repository;

import com.demoRestAPI.account.Entity.Account;
import com.demoRestAPI.account.Entity.Nurse;
import com.demoRestAPI.account.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Long> {

    Nurse findNurseById(Long nurseId);

}
