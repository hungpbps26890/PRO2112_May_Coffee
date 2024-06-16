package com.poly.coffee.service.impl;

import com.poly.coffee.entity.User;
import com.poly.coffee.entity.UserAddress;
import com.poly.coffee.repository.UserAddressRepository;
import com.poly.coffee.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    UserAddressRepository userAddressRepository;

    @Override
    public void deleteNotInUpdatedUserAddress(User user, List<UserAddress> updateUserAddress) {
        List<UserAddress> userAddresses = userAddressRepository.findByUserId(user.getId());
		List<UserAddress> deleteUserAddress = userAddresses.stream().filter(userAddress -> !updateUserAddress.contains(userAddress)).toList();

        userAddressRepository.deleteAllByIdInBatch(deleteUserAddress.stream()
                .map(UserAddress::getId)
                .collect(Collectors.toList())
        );
    }
}
