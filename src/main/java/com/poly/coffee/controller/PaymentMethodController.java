package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.PaymentMethodRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.PaymentMethodResponse;
import com.poly.coffee.entity.PaymentMethod;
import com.poly.coffee.service.PaymentMethodService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payment-methods")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentMethodController {

    PaymentMethodService service;

    @GetMapping
    public ApiResponse<List<PaymentMethodResponse>> getAll() {
        return ApiResponse.<List<PaymentMethodResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<PaymentMethodResponse> getById(@PathVariable("id") Integer id) {
        return ApiResponse.<PaymentMethodResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<PaymentMethodResponse> post(@RequestBody PaymentMethodRequest request) {
        return ApiResponse.<PaymentMethodResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<PaymentMethodResponse> put(@PathVariable("id") Integer id,
                                        @RequestBody PaymentMethodRequest request) {
        return ApiResponse.<PaymentMethodResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Updated successfully!")
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