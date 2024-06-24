package com.poly.coffee.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressUpdateRequest {
     String streetNumber;
     String ward;
     String district;
     String province;
}
