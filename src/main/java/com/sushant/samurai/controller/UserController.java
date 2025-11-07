package com.sushant.samurai.controller;

import com.sushant.samurai.core.dto.ApiResponse;
import com.sushant.samurai.dto.RequestUser;
import com.sushant.samurai.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody @Valid RequestUser requestUser) {
        userService.saveUser(requestUser);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created sucessfully");
//        return userService.saveUser();
    }
        @GetMapping("/list")
        public ResponseEntity<ApiResponse<?>> getUser(){
            return userService.listUsers();
        }

}
