package com.poly.coffee.controller;

import com.poly.coffee.dto.request.AddressCreateRequest;
import com.poly.coffee.dto.request.AddressUpdateRequest;
import com.poly.coffee.dto.response.AddressResponse;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.entity.Address;
import com.poly.coffee.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    ApiResponse<Address> createUser(@RequestBody @Valid AddressCreateRequest request){
        ApiResponse<Address> apiResponse = new ApiResponse<>();

        apiResponse.setResult(addressService.createAddressRequest(request));
        return apiResponse;
    }

    @GetMapping
    List<Address> getAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    AddressResponse getAddress(@PathVariable Long id){
            return addressService.getAddress(id);
    }

    @PutMapping("/{id}")
    AddressResponse updateAddress(@PathVariable Long id, @RequestBody AddressUpdateRequest request){
        return addressService.updateAddress(id, request);
    }

    @DeleteMapping("/{id}")
    String deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return "Address has been deleted";
    }
}
