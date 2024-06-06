package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.OrderDetailRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.OrderDetailResponse;
import com.poly.coffee.dto.response.OrderResponse;
import com.poly.coffee.entity.OrderDetail;
import com.poly.coffee.service.OrderDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderDetailController {

    OrderDetailService service;

    @GetMapping
    public ApiResponse<List<OrderDetailResponse>> getAll() {
        return ApiResponse.<List<OrderDetailResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<OrderDetailResponse> getById(@PathVariable("id") Long id) {
        return ApiResponse.<OrderDetailResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully")
                .result(service.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<OrderDetailResponse> create(@RequestBody OrderDetailRequest request) {
        return ApiResponse.<OrderDetailResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully")
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<OrderDetailResponse> update(@PathVariable("id") Long id,
                                @RequestBody OrderDetailRequest request) {
        return ApiResponse.<OrderDetailResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Updated successfully!")
                .result(service.update(id, request))
                .build();
    }
}
