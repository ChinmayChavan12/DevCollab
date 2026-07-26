package com.Chinmay.DevCollabProject.Repository;

import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
    Optional<UserProfile> findByEmail(String email);
    boolean existsByUsername(String username);
}
