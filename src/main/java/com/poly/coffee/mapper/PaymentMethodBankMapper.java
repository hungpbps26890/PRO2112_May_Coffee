package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.PaymentMethodBankRequest;
import com.poly.coffee.dto.request.PaymentMethodRequest;
import com.poly.coffee.dto.response.PaymentMethodBankResponse;
import com.poly.coffee.dto.response.PaymentMethodResponse;
import com.poly.coffee.entity.PaymentMethod;
import com.poly.coffee.entity.PaymentMethodBank;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentMethodBankMapper {

    PaymentMethodBank toPaymentMethodBank(PaymentMethodBankRequest request);
    PaymentMethodBankResponse toPaymentMethodBankResponse(PaymentMethodBank orderStatus);
    void updatePaymentMethodBank(@MappingTarget PaymentMethodBank paymentMethod, PaymentMethodBankRequest request);

}
