package com.poly.coffee.dto.request;

import com.poly.coffee.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderStatusRequest {
    String name;
    List<Order> orders;
}
