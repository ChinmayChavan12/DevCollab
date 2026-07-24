package com.Chinmay.DevCollabProject.Service;

import com.Chinmay.DevCollabProject.DTO.AuthRequestDTO;
import com.Chinmay.DevCollabProject.DTO.AuthResponseDTO;

public interface AuthenticationServiceInterface {

    String registerUser(AuthRequestDTO authRequestDTO);

    AuthResponseDTO loginUser(AuthRequestDTO authRequestDTO);
}
