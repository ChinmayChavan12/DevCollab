package com.Chinmay.DevCollab.Controller;

import com.Chinmay.DevCollab.DTO.UserProfileRequest;
import com.Chinmay.DevCollab.DTO.UserProfileResponse;
import com.Chinmay.DevCollab.ServiceInterfaces.UserProfileServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileServiceInterface userProfileService;

    @PostMapping("/register")
    public ResponseEntity<UserProfileResponse> userRegistration(@RequestBody UserProfileRequest userProfileRequest){

            UserProfileResponse userProfileResponse = userProfileService.registerUserProfile(userProfileRequest);
            return  ResponseEntity.ok(userProfileResponse);

    }
}
