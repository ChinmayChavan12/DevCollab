package com.Chinmay.DevCollabProject.ServiceImpl;

import com.Chinmay.DevCollabProject.DTO.UserPostDTO;
import com.Chinmay.DevCollabProject.Model.UserPostEntity;
import com.Chinmay.DevCollabProject.Model.UserProfileEntity;
import com.Chinmay.DevCollabProject.Repository.UserPostRepository;
import com.Chinmay.DevCollabProject.Repository.UserProfileRepository;
import com.Chinmay.DevCollabProject.Service.UserPostServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPostServiceImpl implements UserPostServiceInterface {
    private final UserPostRepository userPostRepository;
    private final UserProfileRepository userProfileRepository;
    @Override
    public String createUserPost(UserPostDTO userPostDTO) {
        String currentUserEmail=getCurrentUsername();
        UserProfileEntity currentUser=userProfileRepository.findByEmail(currentUserEmail).orElseThrow();
        UserPostEntity userPost=toEntity(userPostDTO);
        userPost.setPost_owner(currentUser);

        userPostRepository.save(userPost);

        return "Post Created successfully";


    }

    private String  getCurrentUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

    private UserPostEntity toEntity(UserPostDTO userPostDTO) {
        return UserPostEntity.builder()
                .photo_urls(userPostDTO.getPhoto_urls())
                .post_title(userPostDTO.getPost_title())
                .post_content(userPostDTO.getPost_content()).build();
    }
}
