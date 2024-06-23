package com.poly.coffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
<<<<<<< HEAD
    @Column(columnDefinition = "nvarchar(15)")
    private String firstName;
    @Column(columnDefinition = "nvarchar(50)")
    private String lastName;
    private String phoneNumber;
=======

    @Column(columnDefinition = "nvarchar(255)")
    private String firstName;

    @Column(columnDefinition = "nvarchar(255)")
    private String lastName;

    private String phoneNumber;

>>>>>>> 577b8e41541ed6c40646d2197ec3745d9aa624f1
    private LocalDate dob;
    private Boolean isActive;

    @ManyToMany
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_name")
    )
    private Set<Role> roles;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}