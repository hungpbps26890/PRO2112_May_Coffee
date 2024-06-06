package com.poly.coffee.service;

import com.poly.coffee.dto.request.OrderDetailRequest;
import com.poly.coffee.dto.response.OrderDetailResponse;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailResponse> getAll();
    OrderDetailResponse getById(Long id);
    OrderDetailResponse create(OrderDetailRequest request);
    OrderDetailResponse update(Long id, OrderDetailRequest request);
}
