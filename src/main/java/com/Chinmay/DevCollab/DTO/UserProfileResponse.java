package com.Chinmay.DevCollab.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileResponse {
    private String name;
    private String email;
    private String username;
    private String profile_url;
    private String short_bio;
    private String about_me;
}
