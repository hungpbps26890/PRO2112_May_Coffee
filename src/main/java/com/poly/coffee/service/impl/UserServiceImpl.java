package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.UserRequest;
import com.poly.coffee.dto.response.UserResponse;
import com.poly.coffee.entity.User;
import com.poly.coffee.enums.Role;
import com.poly.coffee.exception.AppException;
import com.poly.coffee.exception.ErrorCode;
import com.poly.coffee.mapper.UserMapper;
import com.poly.coffee.repository.UserReponsitory;
import com.poly.coffee.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    UserReponsitory userReponsitory;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toUser(request);
        if(userReponsitory.existsByEmail(request.getEmail())){
            throw  new AppException(ErrorCode.USER_EXISTED);
        }
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.CUSTOMER.name());
        user.setRoles(roles);
        return userMapper.toUserResponse(userReponsitory.save(user));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public List<UserResponse> findAllUser() {
        log.info("In method get Users");
        return userReponsitory.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @PostAuthorize("returnObject.email == authentication.name")
    @Override
    public UserResponse findUserById(Long id) {
        log.info("In method get by id");
        return userMapper.toUserResponse(getFindUserById(id));
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = getFindUserById(id);
        userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userMapper.toUserResponse(userReponsitory.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        getFindUserById(id);
        userReponsitory.deleteById(id);
    }

    @Override
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userReponsitory.findByEmail(name)
                                                .orElseThrow(()
                                                        -> new AppException(ErrorCode.USER_EXISTED));
        return userMapper.toUserResponse(user);
    }


    private User getFindUserById(Long id){
        return userReponsitory.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
    }
}