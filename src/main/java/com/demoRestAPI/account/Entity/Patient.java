package com.demoRestAPI.account.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "patientId")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Patient {

    @Id @GeneratedValue
    @Column(name = "PATIENT_ID")
    private Long patientId;

    private String name;

    private boolean gender;

    private String phone;

    private LocalDateTime birth;

    private boolean emergence;

    @OneToMany
    @JoinTable(name = "ORDER_PAPER",
            joinColumns = @JoinColumn(name="PATIENT_ID"),
            inverseJoinColumns = @JoinColumn(name="ORDER_ID"))
    private List<Order> orders = new ArrayList<>();
}
