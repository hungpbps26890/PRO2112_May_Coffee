package com.poly.coffee.dto.request;

import lombok.Data;

@Data
public class ReviewRequest {
    Integer rating;
    String comment;
    Long orderId;
}
