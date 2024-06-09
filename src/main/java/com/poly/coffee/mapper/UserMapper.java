package com.poly.coffee.mapper;

import com.poly.coffee.dto.request.UserRequest;
import com.poly.coffee.dto.response.UserResponse;
import com.poly.coffee.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);

    void updateUser(@MappingTarget User user, UserRequest request);

    UserResponse toUserResponse(User user);
}