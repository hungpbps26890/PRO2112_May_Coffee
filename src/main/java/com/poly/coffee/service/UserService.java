package com.poly.coffee.service;

import com.poly.coffee.dto.request.DrinkRequest;
import com.poly.coffee.dto.request.UserRequest;
import com.poly.coffee.dto.response.UserResponse;
import com.poly.coffee.entity.User;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);

    List<UserResponse> findAllUser();

    UserResponse findUserById(Long id);

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);

    UserResponse getMyInfo();
}
