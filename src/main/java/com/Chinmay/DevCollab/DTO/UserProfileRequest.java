package com.Chinmay.DevCollab.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRequest {
    private String name;
    private String email;
    private String username;
    private String password;
    private String profile_url;
    private String short_bio;
    private String about_me;
    private Integer age;
}
