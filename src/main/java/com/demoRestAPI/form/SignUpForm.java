package com.demoRestAPI.form;

import com.demoRestAPI.account.Entity.UserType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class SignUpForm {

    @NotBlank
    private UserType userType;

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @Pattern(regexp = "^01(?:0|1|[6-9])-?(\\d{3}|\\d{4})-?(\\d{4})$")
    private String phone;

    @NotBlank
    private boolean gender;

    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")
    @NotBlank
    private LocalDateTime birth;

}
