package com.poly.coffee.service;

import com.poly.coffee.dto.request.OrderRequest;
import com.poly.coffee.dto.request.UpdateOrderStatusRequest;
import com.poly.coffee.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    List<OrderResponse> getOrdersByUser();

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);

    OrderResponse updateOrderStatus(UpdateOrderStatusRequest request);
    
}
