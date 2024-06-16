package com.poly.coffee.dto.response;


import com.poly.coffee.entity.Address;
import com.poly.coffee.model.UserAddressKey;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAddressResponse {
    UserAddressKey id;
    Boolean isDefault;
    Address address;


}
