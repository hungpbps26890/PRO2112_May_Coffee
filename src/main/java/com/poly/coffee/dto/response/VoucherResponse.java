package com.poly.coffee.dto.response;

import com.poly.coffee.entity.Order;
import com.poly.coffee.entity.VoucherType;
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
public class VoucherResponse {
    Long id;
    String discountCode;
    Float amount;
    LocalDateTime beginDate;
    LocalDateTime endDate;
    String image;
    VoucherType voucherType;
    List<Order> orders;
}
