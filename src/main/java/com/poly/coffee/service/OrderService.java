package com.poly.coffee.service;

import com.poly.coffee.dto.request.OrderRequest;
import com.poly.coffee.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAll();
    OrderResponse getById(Long id);
    OrderResponse create(OrderRequest request);
    OrderResponse update(Long id, OrderRequest request);
}
