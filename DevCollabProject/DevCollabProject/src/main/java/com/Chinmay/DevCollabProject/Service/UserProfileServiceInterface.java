package com.Chinmay.DevCollabProject.Service;

import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileDTO;
import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileResponseDTO;

public interface UserProfileServiceInterface {


    String updateUserProfile(UserProfileDTO userProfileDTO);

    UserProfileResponseDTO getUserProfile();
}
