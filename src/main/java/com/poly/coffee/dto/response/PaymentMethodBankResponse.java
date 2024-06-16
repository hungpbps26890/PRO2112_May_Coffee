package com.poly.coffee.dto.response;

import com.poly.coffee.entity.Bank;
import com.poly.coffee.entity.Order;
import com.poly.coffee.entity.PaymentMethod;
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
public class PaymentMethodBankResponse {
    Long id;
    String owner;
    String creditCard;
    Float totalPrice;
    LocalDateTime date;
    PaymentMethod paymentMethod;
    Bank bank;
    List<Order> orders;
}
