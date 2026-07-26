package com.Chinmay.DevCollabProject.ServiceImpl;

import com.Chinmay.DevCollabProject.DTO.AuthDTO.AuthRequestDTO;
import com.Chinmay.DevCollabProject.DTO.AuthDTO.AuthResponseDTO;
import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import com.Chinmay.DevCollabProject.Model.Enums.UserRole;
import com.Chinmay.DevCollabProject.Repository.UserProfileRepository;
import com.Chinmay.DevCollabProject.Security.JwtService;
import com.Chinmay.DevCollabProject.Service.AuthenticationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationServiceInterface {

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String registerUser(AuthRequestDTO authRequestDTO) {

        UserProfile newUser = new UserProfile();
        newUser.setEmail(authRequestDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(authRequestDTO.getPassword()));
        newUser.setRole(UserRole.Role_User);
        userProfileRepository.save(newUser);

        return "User registered successfully";

    }

    @Override
    public AuthResponseDTO loginUser(AuthRequestDTO authRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getEmail(), authRequestDTO.getPassword()));

        String jwtToken=jwtService.generateToken((UserDetails) Objects.requireNonNull(authentication.getPrincipal()));
        return new AuthResponseDTO(jwtToken, authRequestDTO.getEmail());
    }


}
