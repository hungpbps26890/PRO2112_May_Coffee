package com.poly.coffee.dto.request;

import com.poly.coffee.entity.Bank;
import com.poly.coffee.entity.Order;
import com.poly.coffee.entity.PaymentMethod;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentMethodBankRequest {
    String owner;
    String creditCard;
    Float totalPrice;
    LocalDateTime date;
    PaymentMethod paymentMethod;
    Bank bank;
    List<Order> orders;
}
