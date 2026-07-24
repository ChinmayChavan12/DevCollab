package com.Chinmay.DevCollabProject.Controller;

import com.Chinmay.DevCollabProject.DTO.UserPostDTO;
import com.Chinmay.DevCollabProject.Service.UserPostServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class UserPostController {
private final UserPostServiceInterface  userPostService;
    @PostMapping("create")
    public ResponseEntity<String> createUserPost(@RequestBody UserPostDTO userPostDTO){

        return ResponseEntity.ok().body(userPostService.createUserPost(userPostDTO));

    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUserPost( UserPostDTO userPostDTO){

    }

}
