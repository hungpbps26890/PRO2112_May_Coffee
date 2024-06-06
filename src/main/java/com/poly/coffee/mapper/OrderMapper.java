package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.OrderRequest;
import com.poly.coffee.dto.response.OrderResponse;
import com.poly.coffee.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toOrder(OrderRequest request);
    OrderResponse toOrderResponse(Order order);
    void updateOrder(@MappingTarget Order oder, OrderRequest request);
}
