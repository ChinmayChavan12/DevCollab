package com.Chinmay.DevCollabProject.Service;

import com.Chinmay.DevCollabProject.DTO.AuthDTO.AuthRequestDTO;
import com.Chinmay.DevCollabProject.DTO.AuthDTO.AuthResponseDTO;

public interface AuthenticationServiceInterface {

    String registerUser(AuthRequestDTO authRequestDTO);

    AuthResponseDTO loginUser(AuthRequestDTO authRequestDTO);
}
