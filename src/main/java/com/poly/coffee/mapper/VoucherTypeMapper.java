package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.VoucherTypeRequest;
import com.poly.coffee.dto.response.VoucherTypeResponse;
import com.poly.coffee.entity.VoucherType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VoucherTypeMapper {

    VoucherType toVoucherType(VoucherTypeRequest request);
    VoucherTypeResponse toVoucherTypeResponse(VoucherType voucherType);
    void updateVoucherType(@MappingTarget VoucherType voucherType, VoucherTypeRequest request);

}
