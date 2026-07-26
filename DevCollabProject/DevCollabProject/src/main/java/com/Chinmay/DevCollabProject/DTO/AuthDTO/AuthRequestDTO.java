package com.Chinmay.DevCollabProject.DTO.AuthDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequestDTO {

    @NotBlank(message = "Email is a required field.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotBlank(message = "Password is a required field.")
    private String password;
}