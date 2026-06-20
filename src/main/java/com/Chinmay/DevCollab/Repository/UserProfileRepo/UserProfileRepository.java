package com.Chinmay.DevCollab.Repository.UserProfileRepo;

import com.Chinmay.DevCollab.Model.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByEmail(String email);
}
