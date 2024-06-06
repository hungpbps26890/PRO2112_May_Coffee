package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.OrderRequest;
import com.poly.coffee.dto.response.OrderResponse;
import com.poly.coffee.entity.Order;
import com.poly.coffee.mapper.OrderMapper;
import com.poly.coffee.repository.OrderRepository;
import com.poly.coffee.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    OrderRepository repository;
    OrderMapper mapper;

    @Override
    public List<OrderResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getById(Long id) {
        return mapper.toOrderResponse(
                repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Can not found Order"))
        );
    }

    @Override
    public OrderResponse create(OrderRequest request) {
        return mapper.toOrderResponse(repository.save(mapper.toOrder(request)));
    }

    @Override
    public OrderResponse update(Long id, OrderRequest request) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not find Order"));
        mapper.updateOrder(order, request);
        return mapper.toOrderResponse(repository.save(order));
    }
}
