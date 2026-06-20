package com.Chinmay.DevCollab.ServiceImpl;



import com.Chinmay.DevCollab.Model.Entity.UserProfile;
import com.Chinmay.DevCollab.Repository.UserProfileRepo.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserProfile existingProfile=userProfileRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(email));
        return User.builder()
                .username(existingProfile.getEmail())
                .password(existingProfile.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }
}

