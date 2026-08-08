package com.Chinmay.DevCollabProject.Service;

import com.Chinmay.DevCollabProject.DTO.VoteDTO.VoteResponseDTO;
import com.Chinmay.DevCollabProject.Model.Enums.Vote;

public interface VoteServiceInterface {
    VoteResponseDTO doVote(Long postId, Vote voteType);
}
