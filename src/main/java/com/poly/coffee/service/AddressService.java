package com.poly.coffee.service;


import com.poly.coffee.dto.request.AddressCreateRequest;
import com.poly.coffee.dto.request.AddressUpdateRequest;
import com.poly.coffee.dto.response.AddressResponse;
import com.poly.coffee.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    public Address createAddressRequest(AddressCreateRequest request);

    public List<Address> getAllAddress();

    public AddressResponse getAddress(Long id);

    AddressResponse updateAddress(Long id, AddressUpdateRequest request);

    void deleteAddress(Long id);
}
