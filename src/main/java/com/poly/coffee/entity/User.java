package com.poly.coffee.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String email;
     String password;
     String firstName;
     String lastName;
     Boolean isGender;
     LocalDate birthday;
     String phoneNumber;
     String image;
     Boolean isActive;
     Set<String> roles;
}
