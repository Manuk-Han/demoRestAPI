package com.demoRestAPI.account.Entity;

import com.demoRestAPI.account.Entity.Patient;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "recordId")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Record {

    @Id
    @GeneratedValue
    @Column(name = "RECORD_Id")
    private Long recordId;

    @OneToMany
    @JoinTable(name = "MATCHED",
            joinColumns = @JoinColumn(name="RECORD_ID"),
            inverseJoinColumns = @JoinColumn(name="PATIENT_ID") //반대 엔티티의 외래키
    )
    private List<Patient> patientList = new ArrayList<>();
}
