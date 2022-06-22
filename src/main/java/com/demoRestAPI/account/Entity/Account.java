package com.demoRestAPI.account.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private UserType userType;

    private String name;

    private String email;

    private String password;

    private boolean gender;

    private String phone;

    private LocalDateTime birth;

    private boolean emailVerified;

    private String emailCheckToken;

    private LocalDateTime emailCheckTokenGeneratedAt;

    private LocalDateTime joinAt;

    public void generateEmailCheckToken(){
        this.emailCheckToken= UUID.randomUUID().toString();
        this.emailCheckTokenGeneratedAt=LocalDateTime.now();
    }

    public void completeSignUp() {

        this.emailVerified=true;
        this.joinAt=LocalDateTime.now();
    }

    public boolean isValidToken(String token) {
        return this.emailCheckToken.equals(token);
    }

    public boolean canSendConfirmEmail() {
        return this.emailCheckTokenGeneratedAt.isBefore(LocalDateTime.now().minusHours(1));
    }
}
