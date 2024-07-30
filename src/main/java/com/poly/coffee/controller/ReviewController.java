package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.ReviewRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.ReviewResponse;
import com.poly.coffee.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewController {

    ReviewService review;

    @GetMapping
    public ApiResponse<List<ReviewResponse>> getAll() {
        return ApiResponse.<List<ReviewResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(review.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ReviewResponse> getById(@PathVariable("id") Long id) {
        return ApiResponse.<ReviewResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(review.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<ReviewResponse> post(@RequestBody ReviewRequest request) {
        return ApiResponse.<ReviewResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Created successfully!")
                .result(review.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ReviewResponse> put(@PathVariable("id") Long id,
                                        @RequestBody ReviewRequest request) {
        return ApiResponse.<ReviewResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Updated successfully!")
                .result(review.update(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable("id") Long id) {
        review.delete(id);
        return ApiResponse.<String>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("Deleted successfully")
                .build();
    }

}
