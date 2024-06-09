package com.poly.coffee.dto.response;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String email;
    String firstName;
    String lastName;
    Boolean isGender;
    LocalDate birthday;
    String phoneNumber;
    String image;
    Boolean isActive;
    Set<String> roles;
}
