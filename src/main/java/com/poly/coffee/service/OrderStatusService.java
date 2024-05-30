package com.poly.coffee.service;

import com.poly.coffee.dto.request.OrderStatusRequest;
import com.poly.coffee.dto.response.OrderStatusResponse;
import com.poly.coffee.entity.OrderStatus;

import java.util.List;

public interface OrderStatusService {
      List<OrderStatus> getAll();
      OrderStatusResponse getById(Integer id);
      OrderStatusResponse create(OrderStatusRequest request);
      OrderStatusResponse update(Integer id, OrderStatusRequest request);
      void delete(Integer id);
}
