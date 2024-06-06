package com.poly.coffee.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

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
    Long paymentMethodBankId;
    Integer orderStatusId;
}
