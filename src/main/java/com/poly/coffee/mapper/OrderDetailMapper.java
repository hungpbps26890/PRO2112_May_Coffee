package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.OrderDetailRequest;
import com.poly.coffee.dto.response.OrderDetailResponse;
import com.poly.coffee.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetail toOrderDetail(OrderDetailRequest request);
    OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail);
    void updateOrderDetail(@MappingTarget OrderDetail orderDetail, OrderDetailRequest request);

}
