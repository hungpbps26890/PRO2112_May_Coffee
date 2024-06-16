package com.poly.coffee.dto.request;

import com.poly.coffee.entity.Order;
import com.poly.coffee.entity.Voucher;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailRequest {
    String note;
    Long drinkToppingId;
    Voucher voucher;
    Integer drinkSizeId;
    Order order;
}
