package com.poly.coffee.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    String email;
    String password;
    String firstName;
    String lastName;
    Boolean isGender;
    LocalDate birthday;
    String phoneNumber;
    String image;
    Boolean isActive;
}
