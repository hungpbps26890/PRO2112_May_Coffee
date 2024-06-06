package com.poly.coffee.service;

import com.poly.coffee.dto.request.OrderStatusRequest;
import com.poly.coffee.dto.response.OrderStatusResponse;

import java.util.List;

public interface OrderStatusService {
      List<OrderStatusResponse> getAll();
      OrderStatusResponse getById(Integer id);
      OrderStatusResponse create(OrderStatusRequest request);
      OrderStatusResponse update(Integer id, OrderStatusRequest request);
      void delete(Integer id);
}
