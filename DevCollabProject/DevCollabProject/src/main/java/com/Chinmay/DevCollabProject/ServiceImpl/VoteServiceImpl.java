package com.Chinmay.DevCollabProject.ServiceImpl;

import com.Chinmay.DevCollabProject.DTO.VoteDTO.VoteResponseDTO;
import com.Chinmay.DevCollabProject.Model.Entity.UserPost;
import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import com.Chinmay.DevCollabProject.Model.Entity.VoteEntity;
import com.Chinmay.DevCollabProject.Model.Enums.Vote;
import com.Chinmay.DevCollabProject.Repository.UserPostRepository;
import com.Chinmay.DevCollabProject.Repository.UserProfileRepository;
import com.Chinmay.DevCollabProject.Repository.VoteRepository;
import com.Chinmay.DevCollabProject.Service.VoteServiceInterface;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteServiceInterface {

    private final VoteRepository voteRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserPostRepository userPostRepository;


    @Override
    @Transactional
    public VoteResponseDTO doVote(Long postId, Vote voteType) {

        String currentUserEmail=getCurrentUsername();
        UserProfile currentUser=userProfileRepository.findByEmail(currentUserEmail).orElseThrow();
        UserPost post=userPostRepository.findById(postId).orElseThrow();
        Optional<VoteEntity> existingVote=voteRepository.findByUserAndPost(currentUser,post);
        String message="";

        if(existingVote.isEmpty()){
            VoteEntity newVote=new VoteEntity();
            newVote.setPost(post);
            newVote.setUser(currentUser);
            newVote.setVote_type(voteType);
            voteRepository.save(newVote);
            if(voteType==Vote.UP_VOTE){
                post.setUpvotes(post.getUpvotes() + 1);
            }else{
                post.setDownvotes(post.getDownvotes() + 1);
            }
            userPostRepository.save(post);
            message="Voted Successfully!";
        }else{
                VoteEntity vote=existingVote.get();
                if(vote.getVote_type()==voteType){
                        message="You have already voted";
                }else{
                    if(vote.getVote_type()==Vote.UP_VOTE){
                        post.setUpvotes(post.getUpvotes() - 1);
                    }else{
                        post.setDownvotes(post.getDownvotes() - 1);
                    }
                    vote.setVote_type(voteType);

                    if(voteType==Vote.UP_VOTE){
                        post.setUpvotes(post.getUpvotes() + 1);
                    }else{
                        post.setDownvotes(post.getDownvotes() + 1);
                    }
                    voteRepository.save(vote);
                    userPostRepository.save(post);
                    message="Voted updated Successfully!";
                }
        }

        return VoteResponseDTO.builder().voteType(voteType).upvotes(post.getUpvotes()).downvotes(post.getDownvotes()).message(message).build();

    }

    private String  getCurrentUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }
}
