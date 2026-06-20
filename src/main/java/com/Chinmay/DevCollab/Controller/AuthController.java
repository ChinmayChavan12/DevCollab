package com.Chinmay.DevCollab.Controller;

import com.Chinmay.DevCollab.DTO.AuthDTO;
import com.Chinmay.DevCollab.ServiceInterfaces.UserProfileServiceInterface;
import com.Chinmay.DevCollab.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserProfileServiceInterface userProfileService;

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody AuthDTO authDTO) {
        try{
            if(!userProfileService.isProfileActive(authDTO.getEmail())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(
                        "message","Account is not active.Please activate your account first"
                ));
            }
            Map<String,Object> response= userProfileService.authenticateAndGenerateToken(authDTO);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "message",e.getMessage()
            ));
        }
    }

}
