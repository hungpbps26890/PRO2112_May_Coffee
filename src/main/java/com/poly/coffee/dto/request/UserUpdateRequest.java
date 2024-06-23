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
<<<<<<< HEAD
//    String password;
//    LocalDate dob;
//    List<String> roles;
    Boolean isActive;
=======
    LocalDate dob;
    List<String> roles;
>>>>>>> 577b8e41541ed6c40646d2197ec3745d9aa624f1
}