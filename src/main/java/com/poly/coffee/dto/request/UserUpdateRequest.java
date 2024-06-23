package com.poly.coffee.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String email;
    String firstName;
    String lastName;
    String phoneNumber;
//    String password;
//    LocalDate dob;
//    List<String> roles;
    Boolean isActive;
}