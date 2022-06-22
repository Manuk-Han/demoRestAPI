package com.demoRestAPI.account.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class PatientDetailDTO {
    Long patientId;
    LocalDateTime prescribedDate;
}
