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
    Long transactionNo;
    Double amount;
    LocalDateTime payDate;
    String cardType;
    String bankTranNo;
    Integer paymentMethodId;
    Integer bankId;
    Long orderId;
}
