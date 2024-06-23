package com.poly.coffee.service;

import com.poly.coffee.entity.User;
import com.poly.coffee.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
    void deleteNotInUpdatedUserAddress(User user, List<UserAddress> updateUserAddress);
}
