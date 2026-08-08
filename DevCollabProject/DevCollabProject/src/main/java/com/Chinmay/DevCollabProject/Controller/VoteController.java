package com.Chinmay.DevCollabProject.Controller;

import com.Chinmay.DevCollabProject.DTO.VoteDTO.VoteRequestDTO;
import com.Chinmay.DevCollabProject.DTO.VoteDTO.VoteResponseDTO;
import com.Chinmay.DevCollabProject.Model.Enums.Vote;
import com.Chinmay.DevCollabProject.Service.VoteServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VoteController {

    private final VoteServiceInterface voteService;


    @PostMapping("/vote/{id}")
    public ResponseEntity<VoteResponseDTO> doVote(@PathVariable Long id, @RequestBody VoteRequestDTO voteRequestDTO){

        return ResponseEntity.ok().body(voteService.doVote(id,voteRequestDTO.getVoteType()));
    }



}
