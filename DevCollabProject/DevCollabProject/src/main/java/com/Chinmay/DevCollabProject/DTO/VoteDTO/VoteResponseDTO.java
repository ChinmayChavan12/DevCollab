package com.Chinmay.DevCollabProject.DTO.VoteDTO;

import com.Chinmay.DevCollabProject.Model.Enums.Vote;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VoteResponseDTO {

    private Vote voteType;
    private long upvotes;
    private long downvotes;
    private String message;

}
