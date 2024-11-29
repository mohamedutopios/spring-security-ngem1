package org.example.springsecurityproduct.controller;

import org.example.springsecurityproduct.dto.BaseResponseDto;
import org.example.springsecurityproduct.entity.User;
import org.example.springsecurityproduct.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Object registerUser(@RequestBody User user) {
        if(userService.createUser(user)) {
            return new BaseResponseDto("Success");
        }else{
            return new BaseResponseDto("Failed");
        }
    }



}
