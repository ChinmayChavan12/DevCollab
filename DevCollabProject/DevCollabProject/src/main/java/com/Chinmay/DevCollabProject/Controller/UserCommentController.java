package com.Chinmay.DevCollabProject.Controller;

import com.Chinmay.DevCollabProject.DTO.CommentDTO.CommentRequestDTO;
import com.Chinmay.DevCollabProject.DTO.CommentDTO.CommentResponseDTO;

import com.Chinmay.DevCollabProject.Service.UserCommentInterface;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class UserCommentController {

    private final UserCommentInterface userCommentService;

    @PostMapping("/create")
    public ResponseEntity<CommentResponseDTO> createComment(@RequestBody CommentRequestDTO commentRequestDTO){
        CommentResponseDTO userComment=userCommentService.addComment(commentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userComment);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<Page<CommentResponseDTO>> getCommentByPost(@PathVariable Long postId, @RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"createdAt"));
        return ResponseEntity.ok(userCommentService.getCommentByPost(postId,pageable));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String>  deleteComment(@PathVariable Long commentId){
        if(userCommentService.deleteComment(commentId)){
            return ResponseEntity.ok("Successfully deleted comment");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Cannot delete comment");
    }

}
