package com.poly.coffee.dto.response;

import com.poly.coffee.entity.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    Long id;
    Integer totalItems;
    Double totalPrice;
    LocalDateTime createDate;
    Boolean paymentStatus;
    PaymentMethod paymentMethod;
    List<OrderItem> orderItems;
    UserResponse user;
    OrderStatus orderStatus;
    Address address;
    PaymentMethodBank paymentMethodBank;
    Voucher voucher;
}
