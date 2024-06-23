package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.OrderDetailRequest;
import com.poly.coffee.dto.request.OrderRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.OrderDetailResponse;
import com.poly.coffee.dto.response.OrderResponse;
import com.poly.coffee.entity.Order;
import com.poly.coffee.entity.OrderDetail;
import com.poly.coffee.entity.Voucher;
import com.poly.coffee.exception.AppException;
import com.poly.coffee.exception.ErrorCode;
import com.poly.coffee.mapper.OrderDetailMapper;
import com.poly.coffee.mapper.OrderMapper;
import com.poly.coffee.repository.OrderDetailRepository;
import com.poly.coffee.repository.OrderRepository;
import com.poly.coffee.service.OrderDetailService;
import com.poly.coffee.service.OrderService;
import com.poly.coffee.service.VoucherService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailRepository repository;
    OrderDetailMapper mapper;

    @Override
    public List<OrderDetailResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toOrderDetailResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDetailResponse getById(Long id) {
        return mapper.toOrderDetailResponse(repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTS)));
    }

    @Override
    public OrderDetailResponse create(OrderDetailRequest request) {
        return mapper.toOrderDetailResponse(repository.save(mapper.toOrderDetail(request)));
    }

    @Override
    public OrderDetailResponse update(Long id, OrderDetailRequest request) {
        return mapper.toOrderDetailResponse(repository.save(mapper.toOrderDetail(request)));
    }
}
