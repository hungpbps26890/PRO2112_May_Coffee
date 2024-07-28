package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.OrderStatusRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.OrderStatusResponse;
import com.poly.coffee.entity.OrderStatus;
import com.poly.coffee.service.OrderStatusService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/api/order-statuses")
public class OrderStatusController {

    OrderStatusService service;

    @GetMapping
    public ApiResponse<List<OrderStatus>> getAllOrderStatus() {
        return ApiResponse.<List<OrderStatus>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Get all order status successfully")
                .result(service.getAllOrderStatus())
                .build();
    }

    @GetMapping("/all")
    public List<OrderStatus> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OrderStatusResponse getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ApiResponse<OrderStatusResponse> post(@RequestBody OrderStatusRequest request) {
        return ApiResponse.<OrderStatusResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<OrderStatusResponse> put(@PathVariable("id") Long id,
                                                @RequestBody OrderStatusRequest request) {
        return ApiResponse.<OrderStatusResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.update(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ApiResponse.<String>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Deleted successfully")
                .build();
    }
}
