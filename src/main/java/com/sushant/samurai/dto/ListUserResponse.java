package com.sushant.samurai.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ListUserResponse {
    private String username;
    private String email;
    private LocalDate birthday;
    private String gender;
    private String phone;
    private String address;
    private String fullName;
}
