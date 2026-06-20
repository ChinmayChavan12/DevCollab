package com.Chinmay.DevCollab.ServiceInterfaces;

import com.Chinmay.DevCollab.DTO.AuthDTO;
import com.Chinmay.DevCollab.DTO.UserProfileRequest;
import com.Chinmay.DevCollab.DTO.UserProfileResponse;
import com.Chinmay.DevCollab.Model.Entity.UserProfile;

import java.util.Map;

public interface UserProfileServiceInterface {
    UserProfileResponse registerUserProfile(UserProfileRequest userProfileRequest);
    boolean isProfileActive(String email);
    Map<String, Object> authenticateAndGenerateToken(AuthDTO authDTO);
}
