package com.poly.coffee.service;

import com.poly.coffee.dto.request.BankRequest;
import com.poly.coffee.dto.request.ReviewRequest;
import com.poly.coffee.dto.response.BankResponse;
import com.poly.coffee.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewService {
      List<ReviewResponse> getAll();
      ReviewResponse getById(Long id);
      ReviewResponse create(ReviewRequest request);
      ReviewResponse update(Long id, ReviewRequest request);
      void delete(Long id);
}
