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
@RestController
@RequestMapping("/api/order-statuses")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderStatusController {

    OrderStatusService service;

    @GetMapping
    public ApiResponse<List<OrderStatusResponse>> getAll() {
        return ApiResponse.<List<OrderStatusResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<OrderStatusResponse> getById(@PathVariable("id") Integer id) {
        return ApiResponse.<OrderStatusResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<OrderStatusResponse> post(@RequestBody OrderStatusRequest request) {
        return ApiResponse.<OrderStatusResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Updated successfully!")
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<OrderStatusResponse> put(@PathVariable("id") Integer id,
                                        @RequestBody OrderStatusRequest request) {
        return ApiResponse.<OrderStatusResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.update(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ApiResponse.<String>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Deleted successfully")
                .build();
    }

}
