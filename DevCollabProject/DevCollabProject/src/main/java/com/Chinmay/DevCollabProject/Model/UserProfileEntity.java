package com.Chinmay.DevCollabProject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long  user_id;
    private String name;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String profile_url;
    private String short_bio;
    private String about_me;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
