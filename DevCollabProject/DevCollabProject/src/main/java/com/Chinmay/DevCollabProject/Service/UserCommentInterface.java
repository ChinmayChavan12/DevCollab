package com.Chinmay.DevCollabProject.Service;

import com.Chinmay.DevCollabProject.DTO.CommentDTO.CommentRequestDTO;
import com.Chinmay.DevCollabProject.DTO.CommentDTO.CommentResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserCommentInterface {

    CommentResponseDTO addComment(CommentRequestDTO  commentRequestDTO);
    Page<CommentResponseDTO> getCommentByPost(Long postId, Pageable pageable);
    Boolean deleteComment(Long commentId);
}
