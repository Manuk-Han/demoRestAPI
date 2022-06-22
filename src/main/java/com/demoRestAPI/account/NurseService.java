package com.demoRestAPI.account;

import com.demoRestAPI.account.Entity.Order;
import com.demoRestAPI.account.Repository.OrderRepository;
import com.demoRestAPI.account.DTO.OrderDTO;
import com.demoRestAPI.account.DTO.PatientDTO;
import com.demoRestAPI.account.DTO.PatientDetailDTO;
import com.demoRestAPI.account.Entity.Nurse;
import com.demoRestAPI.account.Entity.Patient;
import com.demoRestAPI.account.Repository.NurseRepository;
import com.demoRestAPI.account.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class NurseService {

    private final NurseRepository nurseRepository;
    private final PatientRepository patientRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public List<PatientDTO> getPatients(Long nurseId){
        Nurse nurse = nurseRepository.findNurseById(nurseId);

        List<PatientDTO> patientDTOList = new ArrayList<>();
        for(Patient patient : nurse.getPatients()){
            PatientDTO eachPatient = PatientDTO.builder()
                    .patientId(patient.getPatientId())
                    .name(patient.getName())
                    .birth(patient.getBirth())
                    .gender(patient.isGender())
                    .phone(patient.getPhone())
                    .build();

            patientDTOList.add(eachPatient);
        }

        return patientDTOList;
    }


    public List<PatientDTO> getEmergencePatients(Long nurseId){
        Nurse nurse = nurseRepository.findNurseById(nurseId);

        List<PatientDTO> emergencePatients = new ArrayList<>();
        for(Patient patient : nurse.getPatients()){
            if(patient.isEmergence()){
                PatientDTO eachPatient = PatientDTO.builder()
                        .patientId(patient.getPatientId())
                        .name(patient.getName())
                        .birth(patient.getBirth())
                        .gender(patient.isGender())
                        .phone(patient.getPhone())
                        .build();

                emergencePatients.add(eachPatient);
            }
        }

        return emergencePatients;
    }

    public PatientDetailDTO getPatientsDetail(Long patientId){
        Patient patient = patientRepository.findPatientById(patientId);

        PatientDetailDTO patientDetailDTO = PatientDetailDTO.builder()
                .patientId(patient.getPatientId())
                .build();

        return patientDetailDTO;
    }

    public List<OrderDTO> getOrders(Long patientId){
        Patient patient = patientRepository.findPatientById(patientId);

        List<OrderDTO> orders = new ArrayList<>();
        for(Order order : orderRepository.findOrderById(patient.getPatientId())) {
            OrderDTO orderDTO = OrderDTO.builder()
                    .patientId(patient.getPatientId())
                    .build();

            orders.add(orderDTO);
        }
        return orders;
    }
}
