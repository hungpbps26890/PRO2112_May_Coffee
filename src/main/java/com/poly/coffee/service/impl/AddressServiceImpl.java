package com.poly.coffee.service.impl;


import com.poly.coffee.dto.request.AddressCreateRequest;
import com.poly.coffee.dto.request.AddressUpdateRequest;
import com.poly.coffee.dto.response.AddressResponse;
import com.poly.coffee.entity.Address;
import com.poly.coffee.mapper.AddressMapper;
import com.poly.coffee.repository.AddressRepository;
import com.poly.coffee.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressServiceImpl implements AddressService {

     AddressRepository addressRepository;


     AddressMapper addressMapper;



    @Override
    public Address createAddressRequest(AddressCreateRequest request) {
        Address address = addressMapper.toAddress(request);

        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public AddressResponse getAddress(Integer id) {
        return addressMapper.toAddressResponse(addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not found Address")));
    }

    @Override
    public AddressResponse updateAddress(Integer id, AddressUpdateRequest request) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not found Address"));
        addressMapper.updateAddress(address, request);
        return addressMapper.toAddressResponse(addressRepository.save(address));
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}
