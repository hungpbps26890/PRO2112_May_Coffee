package com.poly.coffee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @Column(columnDefinition = "nvarchar(15)")
    private String firstName;
    @Column(columnDefinition = "nvarchar(50)")
    private String lastName;
    private String phoneNumber;
    private LocalDate dob;
    private Boolean isActive;

    @ManyToMany
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_name")
    )
    private Set<Role> roles;
}