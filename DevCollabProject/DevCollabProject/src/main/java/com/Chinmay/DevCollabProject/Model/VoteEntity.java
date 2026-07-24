package com.Chinmay.DevCollabProject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vote_id;
    @Enumerated(EnumType.STRING)
    private Vote vote_type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserProfileEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private UserPostEntity user_post;


}

