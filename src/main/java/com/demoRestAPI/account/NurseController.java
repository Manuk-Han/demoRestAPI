package com.demoRestAPI.account;

import com.demoRestAPI.account.DTO.OrderDTO;
import com.demoRestAPI.account.DTO.PatientDTO;
import com.demoRestAPI.account.Entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NurseController {

    private final NurseService nurseService;


    @GetMapping(value = "patient/matched")
    @ResponseBody
    public List<PatientDTO> showPatientList(@RequestParam("nurseId") Long nurseId){
        return nurseService.getPatients(nurseId);
    }

    @GetMapping(value = "patient/emergence")
    @ResponseBody
    public List<PatientDTO> showEmergencePatientList(@RequestParam("nurseId") Long nurseId){
        return nurseService.getEmergencePatients(nurseId);
    }

    @GetMapping(value = "patient/emergence")
    @ResponseBody
    public List<OrderDTO> showOrders(@RequestParam("patientId") Long patientId){
        return nurseService.getOrders(patientId);
    }
}
