package com.poly.coffee.service;

import com.poly.coffee.dto.request.OrderStatusRequest;
import com.poly.coffee.dto.response.OrderStatusResponse;
import com.poly.coffee.entity.OrderStatus;

import java.util.List;

public interface OrderStatusService {

    List<OrderStatus> getAllOrderStatus();

    List<OrderStatus> getAll();
    OrderStatusResponse getById(Long id);
    OrderStatusResponse create(OrderStatusRequest request);
    OrderStatusResponse update(Long id, OrderStatusRequest request);
    void delete(Long id);

}
