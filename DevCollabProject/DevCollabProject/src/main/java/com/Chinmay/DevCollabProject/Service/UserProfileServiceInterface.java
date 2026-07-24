package com.Chinmay.DevCollabProject.Service;

import com.Chinmay.DevCollabProject.DTO.UserProfileDTO;
import com.Chinmay.DevCollabProject.DTO.UserProfileResponseDTO;
import com.Chinmay.DevCollabProject.Model.UserProfileEntity;

import java.util.Optional;

public interface UserProfileServiceInterface {


    String updateUserProfile(UserProfileDTO userProfileDTO);

    UserProfileResponseDTO getUserProfile();
}
