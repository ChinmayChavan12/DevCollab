package com.Chinmay.DevCollabProject.Repository;

import com.Chinmay.DevCollabProject.Model.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity,Long> {
}
