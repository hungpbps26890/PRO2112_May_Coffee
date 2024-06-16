package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.OrderStatusRequest;
import com.poly.coffee.dto.response.OrderStatusResponse;
import com.poly.coffee.entity.OrderStatus;
import com.poly.coffee.exception.AppException;
import com.poly.coffee.exception.ErrorCode;
import com.poly.coffee.mapper.OrderStatusMapper;
import com.poly.coffee.repository.OrderStatusRepository;
import com.poly.coffee.service.OrderStatusService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderStatusServiceImpl implements OrderStatusService {

    OrderStatusRepository repository;
    OrderStatusMapper mapper;


    @Override
    public List<OrderStatusResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toOrderStatusResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderStatusResponse getById(Integer id) {
        return mapper.toOrderStatusResponse(repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND)));
    }

    @Override
    public OrderStatusResponse create(OrderStatusRequest request) {
        return mapper.toOrderStatusResponse(repository.save(mapper.toOrderStatus(request)));
    }

    @Override
    public OrderStatusResponse update(Integer id, OrderStatusRequest request) {
        OrderStatus orderStatus = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        mapper.updateOrderStatus(orderStatus, request);
        return mapper.toOrderStatusResponse(repository.save(orderStatus));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND)));
    }
}
