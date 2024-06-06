package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.OrderRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.OrderResponse;
import com.poly.coffee.entity.Order;
import com.poly.coffee.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService service;

    @GetMapping
    public ApiResponse<List<OrderResponse>> getAll() {
        return ApiResponse.<List<OrderResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<OrderResponse> getById(@PathVariable("id") Long id) {
        return ApiResponse.<OrderResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<OrderResponse> create(@RequestBody OrderRequest request) {
        return ApiResponse.<OrderResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully")
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<OrderResponse> update(@PathVariable("id") Long id,
                                @RequestBody OrderRequest request) {
        if (service.getById(id) != null) {
            service.update(id, request);
            return ApiResponse.<OrderResponse>builder()
                    .code(StatusCode.SUCCESS_CODE)
                    .message("Updated successfully!")
                    .build();
        }
        return ApiResponse.<OrderResponse>builder()
                .message("Updated failed!")
                .build();
    }
}
