package com.poly.coffee.dto.request;

import com.poly.coffee.entity.Order;
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
public class VoucherRequest {
    String discountCode;
    Float amount;
    LocalDateTime beginDate;
    LocalDateTime endDate;
    String image;
    Integer voucherTypeId;
    List<Order> orders;
}
