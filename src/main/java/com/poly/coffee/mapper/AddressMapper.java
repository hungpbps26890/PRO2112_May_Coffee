package com.poly.coffee.mapper;



import com.poly.coffee.dto.request.AddressCreateRequest;
import com.poly.coffee.dto.request.AddressUpdateRequest;
import com.poly.coffee.dto.response.AddressResponse;
import com.poly.coffee.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toAddress(AddressCreateRequest request);

    AddressResponse toAddressResponse(Address address);
    void updateAddress(@MappingTarget Address address , AddressUpdateRequest request);
}
