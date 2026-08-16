package com.Chinmay.DevCollabProject.Repository;

import com.Chinmay.DevCollabProject.Model.Entity.UserComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment,Long> {

    Page<UserComment> findByPostId(Long postId, Pageable pageable);
}
