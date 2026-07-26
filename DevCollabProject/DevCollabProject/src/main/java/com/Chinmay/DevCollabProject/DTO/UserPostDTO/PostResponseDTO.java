package com.Chinmay.DevCollabProject.DTO.UserPostDTO;

import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDTO {

    private Long id; // Renamed from post_id; using Long object wrapper
    private String title;
    private String content; // Renamed from post_content
    private List<String> photoUrls; // Renamed from photo_urls
    private Integer upvotes; // Renamed from post_upvotes
    private Integer downvotes; // Renamed from post_downvotes
    private LocalDateTime createdAt; // Renamed from created_at
    private UserProfileResponseDTO userProfile; // Renamed from user_profile
}