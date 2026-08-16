package com.Chinmay.DevCollabProject.DTO.CommentDTO;

import com.Chinmay.DevCollabProject.DTO.UserPostDTO.PostResponseDTO;
import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class CommentResponseDTO {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private Long postId;
    private Long  userId;
    private Long parentCommentId;
    private String  userProfileUrl;
    private String userUsername;

}
