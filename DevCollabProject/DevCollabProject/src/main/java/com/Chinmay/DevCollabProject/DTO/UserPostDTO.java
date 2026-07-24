package com.Chinmay.DevCollabProject.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserPostDTO {
    @NotBlank(message = "Post Title is a required field.")
    private String post_title;
    @NotBlank(message ="Please add Content to the Post.")
    private String post_content;
    private List<String> photo_urls;

}
