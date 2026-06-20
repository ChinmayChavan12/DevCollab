package com.Chinmay.DevCollab.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Name is a required field")
    private String name;


    @NotNull(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    @Pattern(
            regexp = "^[a-zA-Z][a-zA-Z0-9_]{2,19}$",
            message = "Username must start with a letter and contain only letters, numbers, or underscores"
    )
    @Column(unique = true)
    private String username;

    @Email(message = "Enter a valid email")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is a required field")
    private String password;

    @NotNull(message="Age is required")
    @Min(value=18,message="Age must be at least 18")
    @Max(value=100,message = "Age must be less that 100")
    private Integer age;

    private String profile_url;

    @Size(max = 50, message = "Short bio cannot exceed 50 characters")
    private String short_bio;

    @Size(max = 150, message = "About me cannot exceed 150 characters")
    private String about_me;


    @Enumerated(EnumType.STRING)
    private UserRole role;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
