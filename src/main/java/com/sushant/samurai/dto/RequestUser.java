package com.sushant.samurai.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class RequestUser {
    @NotBlank (message = "Name must not be empty")
    private String fullName;
    private String username;
//    @Pattern(
//            //regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=!])(?=\\S+$).{8,20}$",
//            message = "Password must be 8–20 chars long, include upper/lowercase, number, and special character"
//    )
    private String password;
    private String conformance;
    @NotBlank (message = "Name must not be empty")
    private String gender;
    @Email (message ="Must have valid format")
    private String email;
    @Pattern(regexp = "^(97|98)\\d{8}$", message = "Phone number must be 10 digits and start with 97 or 98")
//    @Min(value = 10) @Max(value = 10, message = "must be 10 digit")
    private String phone;
    @Past(message = "Invalid date")
    private LocalDate birthday;
}
