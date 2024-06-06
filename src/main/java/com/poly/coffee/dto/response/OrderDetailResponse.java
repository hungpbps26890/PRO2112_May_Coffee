package com.poly.coffee.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailResponse {
    Long id;
    Integer drinkQuantity;
    Float drinkUnitPrice;
    Integer toppingQuantity;
    Float toppingUnitPrice;
    String note;
    Integer toppingId;
    Integer voucherId;
    Integer drinkSizeId;
    Integer orderId;
}
