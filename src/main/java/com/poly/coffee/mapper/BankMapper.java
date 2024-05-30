package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.BankRequest;
import com.poly.coffee.dto.response.BankResponse;
import com.poly.coffee.entity.Bank;
import com.poly.coffee.entity.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BankMapper {

    Bank toBank(BankRequest  request);
    BankResponse toBankResponse(Bank orderStatus);
    void updateBank(@MappingTarget Bank orderStatus, BankRequest request);

}
