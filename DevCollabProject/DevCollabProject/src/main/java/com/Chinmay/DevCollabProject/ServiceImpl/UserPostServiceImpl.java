package com.Chinmay.DevCollabProject.ServiceImpl;

import com.Chinmay.DevCollabProject.DTO.UserPostDTO.PostRequestDTO;
import com.Chinmay.DevCollabProject.DTO.UserPostDTO.PostResponseDTO;
import com.Chinmay.DevCollabProject.DTO.UserProfileDTO.UserProfileResponseDTO;
import com.Chinmay.DevCollabProject.Model.Entity.UserPost;
import com.Chinmay.DevCollabProject.Model.Entity.UserProfile;
import com.Chinmay.DevCollabProject.Repository.UserPostRepository;
import com.Chinmay.DevCollabProject.Repository.UserProfileRepository;
import com.Chinmay.DevCollabProject.Service.UserPostServiceInterface;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPostServiceImpl implements UserPostServiceInterface {
    private final UserPostRepository userPostRepository;
    private final UserProfileRepository userProfileRepository;
    @Override
    public String createUserPost(PostRequestDTO  postRequestDTO) {
        String currentUserEmail=getCurrentUsername();
        UserProfile currentUser=userProfileRepository.findByEmail(currentUserEmail).orElseThrow();
        UserPost userPost=toEntity(postRequestDTO);
        userPost.setAuthor(currentUser);

        userPostRepository.save(userPost);

        return "Post Created successfully";


    }

    @Override
    public String deleteUserPost(long id) {
       UserPost userPost=userPostRepository.findById(id).orElseThrow();
       String currentUserEmail=getCurrentUsername();
       if(!userPost.getAuthor().getEmail().equals(currentUserEmail)){
           throw new RuntimeException("Unauthorized to delete this post");
       }

       userPostRepository.delete(userPost);
       return "Post Deleted successfully";

    }

    @Override
    @Transactional
    public Page<PostResponseDTO> getAllPosts(Pageable  pageable) {
        return userPostRepository.findAll(pageable).map(this::toResponseDTO);
    }

    @Override
    public Page<PostResponseDTO> getMyPosts(Pageable pageable) {
        String currentUserEmail=getCurrentUsername();
        UserProfile currentUser=userProfileRepository.findByEmail(currentUserEmail).orElseThrow();
        return userPostRepository.findByAuthor(currentUser,pageable).map(this::toResponseDTO);
    }

    @Override
    public Page<PostResponseDTO> getPostByUser(long id, Pageable pageable) {
        UserProfile user = userProfileRepository.findById(id).orElseThrow();
        return userPostRepository.findByAuthor(user, pageable).map(this::toResponseDTO);
    }

    @Override
    public Page<PostResponseDTO> searchByTitleContains(String title, Pageable pageable) {
        return userPostRepository.findByTitleContaining(title,pageable).map(this::toResponseDTO);
    }

    @Override
    public String updateUserPost(Long id,PostRequestDTO postRequestDTO) {
       String currentUserEmail=getCurrentUsername();
       UserPost userPost=userPostRepository.findById(id).orElseThrow();
        if(!userPost.getAuthor().getEmail().equals(currentUserEmail)){
            throw new RuntimeException("Unauthorized to delete this post");
        }
        if (postRequestDTO.getTitle() != null && !postRequestDTO.getTitle().isBlank()) {
            userPost.setTitle(postRequestDTO.getTitle());
        }

        if (postRequestDTO.getContent() != null && !postRequestDTO.getContent().isBlank()) {
            userPost.setContent(postRequestDTO.getContent());
        }

        if (postRequestDTO.getPhotoUrls() != null) {
            userPost.setPhotoUrls(postRequestDTO.getPhotoUrls());
        }

        userPost.setContent(postRequestDTO.getContent());
        userPost.setPhotoUrls(postRequestDTO.getPhotoUrls());
        userPostRepository.save(userPost);

        return "Post Updated successfully";

    }

    private PostResponseDTO toResponseDTO(UserPost userPost) {
        return PostResponseDTO.builder()
                .id(userPost.getId())
                .photoUrls(userPost.getPhotoUrls())
                .title(userPost.getTitle())
                .content(userPost.getContent())
                .upvotes(userPost.getUpvotes())
                .downvotes(userPost.getDownvotes())
                .createdAt(userPost.getCreatedAt())
                .userProfile(UserProfileResponseDTO.builder().id(userPost.getAuthor().getId())
                        .name(userPost.getAuthor().getName())
                        .email(userPost.getAuthor().getEmail())
                        .username(userPost.getAuthor().getUsername())
                        .profile_url(userPost.getAuthor().getProfilePhotoUrl())
                        .build())
                .build();
    }

    private String  getCurrentUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

    private UserPost toEntity(PostRequestDTO postRequestDTO) {
        return UserPost.builder()
                .photoUrls(postRequestDTO.getPhotoUrls())
                .title(postRequestDTO.getTitle())
                .content(postRequestDTO.getContent()).build();
    }
}
