package com.Chinmay.DevCollabProject.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDTO {


    @NotBlank(message ="Email is a required field.")
    private String email;
    @NotBlank(message = "Password is a required field.")
    private String password;
}
