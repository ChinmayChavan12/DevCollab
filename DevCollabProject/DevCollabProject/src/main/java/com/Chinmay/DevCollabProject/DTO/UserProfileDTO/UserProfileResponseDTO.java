package com.Chinmay.DevCollabProject.DTO.UserProfileDTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileResponseDTO {


    private Long id;
    private String name;
    private String email;
    private String username;
    private String profile_url;
    private String short_bio;
    private String about_me;
    private Integer age;
}
