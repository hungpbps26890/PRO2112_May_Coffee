package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.OrderStatusRequest;
import com.poly.coffee.dto.request.PaymentMethodRequest;
import com.poly.coffee.dto.response.OrderStatusResponse;
import com.poly.coffee.dto.response.PaymentMethodResponse;
import com.poly.coffee.entity.OrderStatus;
import com.poly.coffee.entity.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    PaymentMethod  toPaymentMethod(PaymentMethodRequest request);
    PaymentMethodResponse toPaymentMethodResponse(PaymentMethod orderStatus);
    void updatePaymentMethod(@MappingTarget PaymentMethod paymentMethod, PaymentMethodRequest request);

}
