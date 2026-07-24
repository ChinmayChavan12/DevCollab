package com.Chinmay.DevCollabProject.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostRequestDTO {

    @NotBlank(message = "Title for the post is a mandatory field.")
    private String post_title;
    private List<String> post_urls;
    @NotBlank(message = "Post cannot be empty.Please add content.")
    private String post_content;

}
