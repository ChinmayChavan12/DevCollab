package com.Chinmay.DevCollab.ServiceInterfaces;

import com.Chinmay.DevCollab.DTO.UserProfileRequest;
import com.Chinmay.DevCollab.DTO.UserProfileResponse;

public interface UserProfileServiceInterface {
    UserProfileResponse registerUserProfile(UserProfileRequest userProfileRequest);
}
