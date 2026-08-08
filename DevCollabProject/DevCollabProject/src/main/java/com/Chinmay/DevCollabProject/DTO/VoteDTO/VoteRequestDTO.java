package com.Chinmay.DevCollabProject.DTO.VoteDTO;

import com.Chinmay.DevCollabProject.Model.Enums.Vote;
import lombok.Data;

@Data
public class VoteRequestDTO {

    private Vote voteType;
}
