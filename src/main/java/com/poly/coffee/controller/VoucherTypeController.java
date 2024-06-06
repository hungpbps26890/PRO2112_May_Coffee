package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.VoucherTypeRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.VoucherTypeResponse;
import com.poly.coffee.entity.VoucherType;
import com.poly.coffee.service.VoucherTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/voucher-types")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoucherTypeController {

    VoucherTypeService service;

    @GetMapping
    public ApiResponse<List<VoucherTypeResponse>> getAll() {
        return ApiResponse.<List<VoucherTypeResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<VoucherTypeResponse> getById(@PathVariable("id") Integer id) {
        return ApiResponse.<VoucherTypeResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<VoucherTypeResponse> post(@RequestBody VoucherTypeRequest request) {
        return ApiResponse.<VoucherTypeResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<VoucherTypeResponse> put(@PathVariable("id") Integer id,
                                        @RequestBody VoucherTypeRequest request) {
        return ApiResponse.<VoucherTypeResponse>builder()
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
