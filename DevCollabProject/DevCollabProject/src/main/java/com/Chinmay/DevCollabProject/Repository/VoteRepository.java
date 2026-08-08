package com.Chinmay.DevCollabProject.Repository;

import com.Chinmay.DevCollabProject.Model.Entity.UserPost;
import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import com.Chinmay.DevCollabProject.Model.Entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity,Long> {

    Optional<VoteEntity> findByUserAndPost(UserProfile user, UserPost post);

}
