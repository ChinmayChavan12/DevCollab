package com.Chinmay.DevCollabProject.DTO.UserPostDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDTO {

    @NotBlank(message = "Title for the post is a mandatory field.")
    @Size(max = 150, message = "Title cannot exceed 150 characters.")
    private String title; // Renamed from post_title

    private List<String> photoUrls; // Renamed from post_urls for clarity

    @NotBlank(message = "Post cannot be empty. Please add content.")
    private String content; // Renamed from post_content
}