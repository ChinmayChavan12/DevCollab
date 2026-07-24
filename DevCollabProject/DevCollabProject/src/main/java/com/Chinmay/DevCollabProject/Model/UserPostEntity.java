package com.Chinmay.DevCollabProject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    @ElementCollection
    private List<String> photo_urls;
    private String post_title;
    private String post_content;
    private Integer post_upvotes=0;
    private Integer post_downvotes=0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_owner_id")
    private UserProfileEntity post_owner;

    @OneToMany(mappedBy = "user_post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoteEntity> votes;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
