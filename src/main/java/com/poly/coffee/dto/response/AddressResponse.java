package com.poly.coffee.dto.response;

import com.poly.coffee.entity.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressResponse {
     String streetNumber;
     String ward;
     String district;
     String province;
     List<Order> orders;
}
