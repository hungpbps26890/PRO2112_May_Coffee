package com.poly.coffee.controller;

import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.UserRequest;
import com.poly.coffee.dto.response.ApiResponse;
import com.poly.coffee.dto.response.CategoryResponse;
import com.poly.coffee.dto.response.UserResponse;
import com.poly.coffee.entity.User;
import com.poly.coffee.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserRequest request){
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> findAllUser(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("email: {}", authentication.getName());
        authentication.getAuthorities()
                .forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return ApiResponse.<List<UserResponse>>builder()
                .code(StatusCode.SUCCESS_CODE)
                .result(userService.findAllUser())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> findUserByID(@PathVariable("id") Long id){
        return ApiResponse.<UserResponse>builder()
                .result(userService.findUserById(id))
                .build();
    }

    @GetMapping("/myInfor")
    public ApiResponse<UserResponse> getMyInfor(){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id,
                                   @RequestBody UserRequest request){
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleleUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "delete thanh cong";
    }


}
