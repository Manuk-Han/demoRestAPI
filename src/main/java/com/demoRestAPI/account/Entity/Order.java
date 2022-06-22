package com.demoRestAPI.account.Entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "patientId")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long orderId;

    private Long patientId;

    private LocalDateTime prescribedDate;
}
