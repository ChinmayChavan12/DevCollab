package com.Chinmay.DevCollabProject.Controller;

import com.Chinmay.DevCollabProject.DTO.AuthRequestDTO;
import com.Chinmay.DevCollabProject.DTO.AuthResponseDTO;
import com.Chinmay.DevCollabProject.Service.AuthenticationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationServiceInterface authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthRequestDTO authRequestDTO) {

        return ResponseEntity.ok().body(authenticationService.registerUser(authRequestDTO));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> loginUser(@RequestBody AuthRequestDTO authRequestDTO) {

        return ResponseEntity.ok().body(authenticationService.loginUser(authRequestDTO));
    }

    @GetMapping("/test")
    public String test() {
        return "working";
    }

}
