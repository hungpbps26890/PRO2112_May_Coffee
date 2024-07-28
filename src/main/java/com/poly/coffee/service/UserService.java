package com.poly.coffee.service;

import com.poly.coffee.dto.request.*;
import com.poly.coffee.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createRequest(UserCreationRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse getMyInfo();

    UserResponse updateUser(Long id, UserUpdateRequest request);

    UserResponse updateMyInfo(UserUpdateMyInfoRequest request);

    UserResponse lockUser(Long id);

    void deleteUser(Long id);

    void changePassword(ChangePasswordRequest request);
}