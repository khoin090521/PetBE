package com.example.petbe.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String full_name;
}
