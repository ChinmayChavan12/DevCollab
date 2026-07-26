package com.Chinmay.DevCollabProject.Service;

import com.Chinmay.DevCollabProject.DTO.UserPostDTO.PostRequestDTO;
import com.Chinmay.DevCollabProject.DTO.UserPostDTO.PostResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserPostServiceInterface {
    String createUserPost(PostRequestDTO postRequestDTO);

    String deleteUserPost(long id);

    Page<PostResponseDTO> getAllPosts(Pageable pageable);

    Page<PostResponseDTO> getMyPosts(Pageable pageable);

    Page<PostResponseDTO> getPostByUser(long id, Pageable pageable);

    Page<PostResponseDTO> searchByTitleContains(String title, Pageable pageable);

    String updateUserPost(Long id,PostRequestDTO postRequestDTO);
}
