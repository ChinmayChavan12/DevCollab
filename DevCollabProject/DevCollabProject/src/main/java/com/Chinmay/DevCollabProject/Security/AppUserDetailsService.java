package com.Chinmay.DevCollabProject.Security;


import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import com.Chinmay.DevCollabProject.Repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserProfile userProfileEntity = userProfileRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"+email));
        return User.builder()
                .username(userProfileEntity.getEmail())
                .password(userProfileEntity.getPassword())
                .roles(userProfileEntity.getRole().name())
                .build();
    }
}
