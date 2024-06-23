package com.poly.coffee.dto.request;

import com.poly.coffee.entity.Order;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressCreateRequest {
    String streetnumber;
    String ward;
    String district;
    String province;
    List<Order> orders;
}
