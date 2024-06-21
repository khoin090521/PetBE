package com.example.petbe.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDto {
    private String gmail;

    private String full_name;

    private String password;

    private String address;

    private String phone_number;
}
