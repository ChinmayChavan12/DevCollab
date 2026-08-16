package com.Chinmay.DevCollabProject.ServiceImpl;

import com.Chinmay.DevCollabProject.DTO.CommentDTO.CommentRequestDTO;
import com.Chinmay.DevCollabProject.DTO.CommentDTO.CommentResponseDTO;
import com.Chinmay.DevCollabProject.Model.Entity.UserComment;
import com.Chinmay.DevCollabProject.Model.Entity.UserPost;
import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import com.Chinmay.DevCollabProject.Repository.UserCommentRepository;
import com.Chinmay.DevCollabProject.Repository.UserPostRepository;
import com.Chinmay.DevCollabProject.Repository.UserProfileRepository;
import com.Chinmay.DevCollabProject.Service.UserCommentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;



@Service
@RequiredArgsConstructor
public class UserCommentServiceImpl implements UserCommentInterface {

    private final UserCommentRepository userCommentRepository;
    private final UserProfileRepository  userProfileRepository;
    private final UserPostRepository       userPostRepository;

    @Override
    public CommentResponseDTO addComment(CommentRequestDTO commentRequestDTO) {
        UserComment userComment = new UserComment();
        userComment.setContent(commentRequestDTO.getContent());



        UserProfile author=userProfileRepository.findByEmail(getCurrentUsername()).orElseThrow();
        UserPost post=userPostRepository.findById(commentRequestDTO.getPostId()).orElseThrow();
        userComment.setAuthor(author);
        userComment.setPost(post);

        if(commentRequestDTO.getParentId()!=null){
            UserComment parentComment = userCommentRepository.findById(commentRequestDTO.getParentId()).orElseThrow();
            userComment.setParent(parentComment);
        }else{
            userComment.setParent(null);
        }

         userCommentRepository.save(userComment);

        return toDTO(userComment);

    }

    @Override
    public Page<CommentResponseDTO> getCommentByPost(Long postId, Pageable pageable) {
        return userCommentRepository.findByPostId(postId,pageable).map(this::toDTO);
    }

    @Override
    public Boolean deleteComment(Long commentId) {
        UserComment userComment = userCommentRepository.findById(commentId).orElseThrow();
        UserProfile author=userProfileRepository.findByEmail(getCurrentUsername()).orElseThrow();
        if(userComment.getAuthor().getId().equals(author.getId())){
            userCommentRepository.delete(userComment);
            return true;
        }

        return false;
    }


    private CommentResponseDTO toDTO(UserComment userComment) {
        return CommentResponseDTO.builder().id(userComment.getId()).content(userComment.getContent()).parentCommentId(userComment.getParent() != null ? userComment.getParent().getId() : null).createdAt(userComment.getCreatedAt()).postId(userComment.getPost().getId()).userId(userComment.getAuthor().getId()).userProfileUrl(userComment.getAuthor().getProfilePhotoUrl()).userUsername(userComment.getAuthor().getUsername()).build();
    }

    private String  getCurrentUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }
}
