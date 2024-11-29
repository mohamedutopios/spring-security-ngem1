package org.example.springsecurityproduct.controller;

import org.example.springsecurityproduct.dto.BaseResponseDto;
import org.example.springsecurityproduct.dto.UserLoginDto;
import org.example.springsecurityproduct.entity.User;
import org.example.springsecurityproduct.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public BaseResponseDto registerUser(@RequestBody User user) {
        if(userService.createUser(user)) {
            return new BaseResponseDto("Success");
        }else{
            return new BaseResponseDto("Failed");
        }
    }

    @PostMapping("/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto userLoginDto) {

        if(userService.checkUserExist(userLoginDto.getEmail())){
            if(userService.verifyUser(userLoginDto.getEmail(), userLoginDto.getPassword())){
                Map<String, Object>data = new HashMap<>();
                data.put("token",userService.generateToken(userLoginDto.getEmail(), userLoginDto.getPassword()));
                return new BaseResponseDto("Success",data);
            }else{
                return new BaseResponseDto("wrong password");
            }
        }else{
            return new BaseResponseDto("user not exist");
        }
    }


}
