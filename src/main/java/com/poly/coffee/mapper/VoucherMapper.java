package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.VoucherRequest;
import com.poly.coffee.dto.response.VoucherResponse;
import com.poly.coffee.entity.Voucher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VoucherMapper {

    Voucher toVoucher(VoucherRequest request);
    VoucherResponse toVoucherResponse(Voucher Voucher);
    void updateVoucher(@MappingTarget Voucher Voucher, VoucherRequest request);

}
