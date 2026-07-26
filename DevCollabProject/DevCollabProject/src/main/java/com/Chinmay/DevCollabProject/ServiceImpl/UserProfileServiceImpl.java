package com.Chinmay.DevCollabProject.ServiceImpl;

import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileDTO;
import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileResponseDTO;
import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import com.Chinmay.DevCollabProject.Repository.UserProfileRepository;
import com.Chinmay.DevCollabProject.Service.UserProfileServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileServiceInterface {

    private final UserProfileRepository userProfileRepository;

    @Override
    public String updateUserProfile(UserProfileDTO userProfileDTO) {
        String currentUserEmail=getCurrentUsername();
        UserProfile userProfile=userProfileRepository.findByEmail(currentUserEmail).orElseThrow();
        if(userProfileRepository.existsByUsername(userProfileDTO.getUsername())&&!userProfile.getUsername().equals(userProfileDTO.getUsername()))
        {
            return "User with following: "+userProfileDTO.getUsername()+" already exists";
        }

        userProfile.setName(userProfileDTO.getName());
        userProfile.setUsername(userProfileDTO.getUsername());
        userProfile.setAge(userProfileDTO.getAge());
        userProfile.setAboutMe(userProfileDTO.getAbout_me());
        userProfile.setProfilePhotoUrl(userProfileDTO.getProfile_url());
        userProfile.setBio(userProfileDTO.getShort_bio());
        userProfileRepository.save(userProfile);

        return "User Profile updated successfully";

    }

    @Override
    public UserProfileResponseDTO getUserProfile() {
        UserProfile user= userProfileRepository.findByEmail(getCurrentUsername()).orElseThrow();

        return UserProfileResponseDTO.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).username(user.getUsername()).profile_url(user.getProfilePhotoUrl()).short_bio(user.getBio()).about_me(user.getAboutMe()).age(user.getAge()).build();

    }

    private String  getCurrentUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

}
