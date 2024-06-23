package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.PaymentMethodBankRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.PaymentMethodBankResponse;
import com.poly.coffee.entity.PaymentMethodBank;
import com.poly.coffee.service.PaymentMethodBankService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payment-method-banks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentMethodBankController {

    PaymentMethodBankService service;

    @GetMapping
    public ApiResponse<List<PaymentMethodBankResponse>> getAll() {
        return ApiResponse.<List<PaymentMethodBankResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<PaymentMethodBankResponse> getById(@PathVariable("id") Long id) {
        return ApiResponse.<PaymentMethodBankResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<PaymentMethodBankResponse> post(@RequestBody PaymentMethodBankRequest request) {
        return ApiResponse.<PaymentMethodBankResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Deleted successfully!")
                .result(service.create(request))
                .build();
    }

}
