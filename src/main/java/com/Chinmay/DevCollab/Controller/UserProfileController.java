package com.Chinmay.DevCollab.Controller;

import com.Chinmay.DevCollab.DTO.UserProfileRequest;
import com.Chinmay.DevCollab.DTO.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserProfileController {

    private final

    @PostMapping("/register")
    public ResponseEntity<UserProfileResponse> UserRegistration(@RequestBody UserProfileRequest userProfileRequest){



    }
}
