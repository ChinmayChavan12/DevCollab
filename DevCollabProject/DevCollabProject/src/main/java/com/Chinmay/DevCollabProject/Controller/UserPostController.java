package com.Chinmay.DevCollabProject.Controller;

import com.Chinmay.DevCollabProject.DTO.UserPostDTO.PostRequestDTO;
import com.Chinmay.DevCollabProject.DTO.UserPostDTO.PostResponseDTO;
import com.Chinmay.DevCollabProject.Service.UserPostServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class UserPostController {

    private final UserPostServiceInterface  userPostService;

    @PostMapping("/create")
    public ResponseEntity<String> createUserPost(@RequestBody PostRequestDTO postRequestDTO){

        return ResponseEntity.ok().body(userPostService.createUserPost(postRequestDTO));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserPost(@PathVariable long id){

        return ResponseEntity.ok().body(userPostService.deleteUserPost(id));

    }

    @GetMapping("/posts")
    public ResponseEntity<Page<PostResponseDTO>> getAllPosts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"createdAt"));
        return ResponseEntity.ok().body(userPostService.getAllPosts(pageable));
    }

    @GetMapping("/my-posts")
    public ResponseEntity<Page<PostResponseDTO>> getAllPostsOfAUser(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){

        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"createdAt"));
        return ResponseEntity.ok().body(userPostService.getMyPosts(pageable));

    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Page<PostResponseDTO>> getPostByUser(@PathVariable long id, @RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"createdAt"));

        return ResponseEntity.ok().body(userPostService.getPostByUser(id,pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<PostResponseDTO>> searchByTitleContains(@RequestParam String title, @RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"createdAt"));
        return ResponseEntity.ok().body(userPostService.searchByTitleContains(title,pageable));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserPost(@PathVariable Long id,@RequestBody PostRequestDTO postRequestDTO){
        return ResponseEntity.ok().body(userPostService.updateUserPost(id,postRequestDTO));
    }

}
