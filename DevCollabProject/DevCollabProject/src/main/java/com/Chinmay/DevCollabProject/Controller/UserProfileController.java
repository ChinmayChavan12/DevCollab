package com.Chinmay.DevCollabProject.Controller;


import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileDTO;
import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileResponseDTO;
import com.Chinmay.DevCollabProject.Service.UserProfileServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserProfileController {

    private final UserProfileServiceInterface userProfileService;

    @PutMapping("/profile")
    public ResponseEntity<String> updateUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        return ResponseEntity.ok().body(userProfileService.updateUserProfile(userProfileDTO));
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponseDTO> getUserProfile() {
        return ResponseEntity.ok().body(userProfileService.getUserProfile());
    }

}
