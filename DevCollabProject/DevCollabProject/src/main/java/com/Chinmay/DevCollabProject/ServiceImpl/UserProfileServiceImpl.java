package com.Chinmay.DevCollabProject.ServiceImpl;

import com.Chinmay.DevCollabProject.DTO.UserProfileDTO;
import com.Chinmay.DevCollabProject.DTO.UserProfileResponseDTO;
import com.Chinmay.DevCollabProject.Model.UserProfileEntity;
import com.Chinmay.DevCollabProject.Repository.UserProfileRepository;
import com.Chinmay.DevCollabProject.Service.UserProfileServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileServiceInterface {

    private final UserProfileRepository userProfileRepository;

    @Override
    public String updateUserProfile(UserProfileDTO userProfileDTO) {
        String currentUserEmail=getCurrentUsername();
        UserProfileEntity userProfile=userProfileRepository.findByEmail(currentUserEmail).orElseThrow();
        if(userProfileRepository.existsByUsername(userProfileDTO.getUsername())&&!userProfile.getUsername().equals(userProfileDTO.getUsername()))
        {
            return "User with following: "+userProfileDTO.getUsername()+" already exists";
        }

        userProfile.setName(userProfileDTO.getName());
        userProfile.setUsername(userProfileDTO.getUsername());
        userProfile.setAge(userProfileDTO.getAge());
        userProfile.setAbout_me(userProfileDTO.getAbout_me());
        userProfile.setProfile_url(userProfileDTO.getProfile_url());
        userProfile.setShort_bio(userProfileDTO.getShort_bio());
        userProfileRepository.save(userProfile);

        return "User Profile updated successfully";

    }

    @Override
    public UserProfileResponseDTO getUserProfile() {
        UserProfileEntity user= userProfileRepository.findByEmail(getCurrentUsername()).orElseThrow();

        return UserProfileResponseDTO.builder().name(user.getName()).email(user.getEmail()).username(user.getUsername()).profile_url(user.getProfile_url()).short_bio(user.getShort_bio()).about_me(user.getAbout_me()).age(user.getAge()).build();

    }

    private String  getCurrentUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

}
