package com.poly.coffee.dto.request;

import com.poly.coffee.entity.Order;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

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
    List<Order> orders;
}
