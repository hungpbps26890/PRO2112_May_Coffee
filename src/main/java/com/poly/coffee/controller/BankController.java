package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.BankRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.BankResponse;
import com.poly.coffee.entity.Bank;
import com.poly.coffee.service.BankService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BankController {

    BankService service;

    @GetMapping
    public ApiResponse<List<BankResponse>> getAll() {
        return ApiResponse.<List<BankResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<BankResponse> getById(@PathVariable("id") Integer id) {
        return ApiResponse.<BankResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(service.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<BankResponse> post(@RequestBody BankRequest request) {
        return ApiResponse.<BankResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<BankResponse> put(@PathVariable("id") Integer id,
                                        @RequestBody BankRequest request) {
        return ApiResponse.<BankResponse>builder()
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
