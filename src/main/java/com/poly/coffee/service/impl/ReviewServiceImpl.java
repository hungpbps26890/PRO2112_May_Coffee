package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.ReviewRequest;
import com.poly.coffee.dto.response.ReviewResponse;
import com.poly.coffee.entity.Order;
import com.poly.coffee.entity.Review;
import com.poly.coffee.entity.Voucher;
import com.poly.coffee.entity.VoucherType;
import com.poly.coffee.exception.AppException;
import com.poly.coffee.exception.ErrorCode;
import com.poly.coffee.mapper.ReviewMapper;
import com.poly.coffee.repository.OrderRepository;
import com.poly.coffee.repository.ReviewRepository;
import com.poly.coffee.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository repository;
    ReviewMapper  mapper;
    OrderRepository orderRepository;


    @Override
    public List<ReviewResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toReviewResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponse getById(Long id) {
        return mapper.toReviewResponse(repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.REVIEW_NOT_FOUND)));
    }

    @Override
    public ReviewResponse create(ReviewRequest  request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        ReviewRequest reviewRequest = request;
        Review review = mapper.toReview(reviewRequest);
        review.setOrder(order);
        return mapper.toReviewResponse(repository.save(review));
    }

    @Override
    public ReviewResponse update(Long id, ReviewRequest request) {
        Review review = repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.REVIEW_NOT_FOUND));
        mapper.updateReview(review, request);
        return mapper.toReviewResponse(repository.save(review));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BANK_NOT_FOUND)));
    }
}
