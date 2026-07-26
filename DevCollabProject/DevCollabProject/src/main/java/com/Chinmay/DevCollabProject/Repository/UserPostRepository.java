package com.Chinmay.DevCollabProject.Repository;

import com.Chinmay.DevCollabProject.Model.Entity.UserPost;
import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository extends JpaRepository<UserPost, Long> {
    Page<UserPost> findAll(Pageable pageable);
    Page<UserPost> findByAuthor(UserProfile author, Pageable pageable);
    Page<UserPost> findByTitleContaining(String title, Pageable pageable);
}
