package com.Chinmay.DevCollab.ServiceImpl;

import com.Chinmay.DevCollab.DTO.AuthDTO;
import com.Chinmay.DevCollab.DTO.UserProfileRequest;
import com.Chinmay.DevCollab.DTO.UserProfileResponse;
import com.Chinmay.DevCollab.Model.Entity.UserProfile;
import com.Chinmay.DevCollab.Model.Entity.UserRole;
import com.Chinmay.DevCollab.Repository.UserProfileRepo.UserProfileRepository;
import com.Chinmay.DevCollab.ServiceInterfaces.UserProfileServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserProfileService implements UserProfileServiceInterface {

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserProfileResponse registerUserProfile(UserProfileRequest userProfileRequest) {
            UserProfile newUserProfile = ToUserProfileEntity(userProfileRequest);
            userProfileRepository.save(newUserProfile);
            return ToUserProfileResponse(newUserProfile);
    }

    @Override
    public boolean isProfileActive(String email) {
        return false;
    }

    @Override
    public Map<String, Object> authenticateAndGenerateToken(AuthDTO authDTO) {
        return Map.of();
    }

    public UserProfile ToUserProfileEntity(UserProfileRequest userProfileRequest) {
        UserProfile newUserProfile =UserProfile.builder()
                .name(userProfileRequest.getName())
                .username(userProfileRequest.getUsername())
                .email(userProfileRequest.getEmail())
                .password(passwordEncoder.encode(userProfileRequest.getPassword()))
                .age(userProfileRequest.getAge())
                .profile_url(userProfileRequest.getProfile_url())
                .short_bio(userProfileRequest.getShort_bio())
                .about_me(userProfileRequest.getAbout_me())
                .role(UserRole.ROLE_USER).build();
        return newUserProfile;
    }

    public UserProfileResponse ToUserProfileResponse(UserProfile userProfile) {
        UserProfileResponse userProfileResponse = UserProfileResponse.builder()
                .name(userProfile.getName())
                .email(userProfile.getEmail())
                .username(userProfile.getUsername())
                .profile_url(userProfile.getProfile_url())
                .short_bio(userProfile.getShort_bio())
                .about_me(userProfile.getAbout_me())
                .build();
        return userProfileResponse;
    }


}
