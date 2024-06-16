package com.poly.coffee.dto.request;

import com.poly.coffee.entity.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    Float totalPrice;
    String userName;
    LocalDateTime createDate;
    Integer paymentStatus;
    Integer tableNumber;
    Integer deliveryCharge;
    Long paymentMethodBId;
    OrderStatus orderStatus;
    PaymentMethodBank paymentMethodBank;
    User user;
    Long addressId;
    Long reviewId;
    List<OrderDetail> orders;
}
