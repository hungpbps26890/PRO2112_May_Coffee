package com.poly.coffee.mapper;


import com.poly.coffee.dto.request.ReviewRequest;
import com.poly.coffee.dto.response.ReviewResponse;
import com.poly.coffee.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review toReview(ReviewRequest request);
    ReviewResponse toReviewResponse(Review review);
    void updateReview(@MappingTarget Review review, ReviewRequest request);

}
