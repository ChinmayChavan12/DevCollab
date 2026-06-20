package com.Chinmay.DevCollab.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDTO {
    private String email;
    private String password;
    private String token;
}
