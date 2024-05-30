package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.OrderStatusRequest;
import com.poly.coffee.dto.response.OrderStatusResponse;
import com.poly.coffee.entity.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {

    OrderStatus toOrderStatus(OrderStatusRequest request);
    OrderStatusResponse toOrderStatusResponse(OrderStatus orderStatus);
    void updateOrderStatus(@MappingTarget OrderStatus orderStatus, OrderStatusRequest request);

}
