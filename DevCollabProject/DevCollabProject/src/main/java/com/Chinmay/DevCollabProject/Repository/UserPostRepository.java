package com.Chinmay.DevCollabProject.Repository;

import com.Chinmay.DevCollabProject.Model.UserPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository extends JpaRepository<UserPostEntity, Long> {
}
