package com.Chinmay.DevCollabProject.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_posts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Renamed from post_id

    private String title; // Renamed from post_title

    @Column(columnDefinition = "TEXT")
    private String content; // Renamed from post_content

    @ElementCollection
    @CollectionTable(name = "post_photo_urls", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "photo_url")
    private List<String> photoUrls; // Renamed from photo_urls

    @Builder.Default
    private Integer upvotes = 0; // Added @Builder.Default so Lombok respects '0'

    @Builder.Default
    private Integer downvotes = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile author; // Renamed from post_owner for clarity

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<VoteEntity> votes = new ArrayList<>(); // Note: verify 'mappedBy' matches the field in VoteEntity!

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}