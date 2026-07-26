package com.Chinmay.DevCollabProject.DTO.UserProfileDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {
    @NotBlank(message="Name is a required field.")
    private String name;
    @NotBlank(message="Username is a required field.")
    private String username;
    private String profile_url;
    private String short_bio;
    private String about_me;
    @NotNull(message = "Age is a required field.")
    @Min(value = 18, message = "Age cannot be negative.")
    private Integer age;

}
