package com.Chinmay.DevCollabProject.Model.Entity;

import com.Chinmay.DevCollabProject.Model.Enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long  id;

    private String name;

    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private String profilePhotoUrl;

    private String bio;

    @Column(columnDefinition = "TEXT")
    private String aboutMe;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
