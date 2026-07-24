package com.Chinmay.DevCollabProject.Repository;

import com.Chinmay.DevCollabProject.Model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity,Long> {
    Optional<UserProfileEntity> findByEmail(String email);
    boolean existsByUsername(String username);
}
