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

    public AddressResponse getAddress(Integer id);

    public AddressResponse updateAddress(Integer id, AddressUpdateRequest request);

    public void deleteAddress(Integer id);


}
