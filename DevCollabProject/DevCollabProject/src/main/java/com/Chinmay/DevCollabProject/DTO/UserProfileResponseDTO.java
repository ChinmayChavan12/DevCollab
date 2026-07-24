package com.Chinmay.DevCollabProject.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileResponseDTO {

    private String name;
    private String email;
    private String username;
    private String profile_url;
    private String short_bio;
    private String about_me;
    private Integer age;
}
