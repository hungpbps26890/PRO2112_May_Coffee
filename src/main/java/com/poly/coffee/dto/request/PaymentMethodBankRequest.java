package com.poly.coffee.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentMethodBankRequest {
    String owner;
    String creditCard;
    Float totalPrice;
    LocalDateTime date;
    Integer paymentMethodId;
    Integer bankId;
}
