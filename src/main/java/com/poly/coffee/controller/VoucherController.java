package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.VoucherRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.VoucherResponse;
import com.poly.coffee.entity.Voucher;
import com.poly.coffee.service.VoucherService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vouchers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoucherController {

    VoucherService service;

    @GetMapping
    public ApiResponse<List<VoucherResponse>> getAll() {
        return ApiResponse.<List<VoucherResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<VoucherResponse> getById(@PathVariable("id") Integer id) {
        return ApiResponse.<VoucherResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<VoucherResponse> post(@RequestBody VoucherRequest request) {
        return ApiResponse.<VoucherResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<VoucherResponse> put(@PathVariable("id") Integer id,
                                        @RequestBody VoucherRequest request) {
        return ApiResponse.<VoucherResponse>builder()
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
