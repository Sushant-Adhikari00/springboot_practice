package com.sushant.samurai.service;

import com.sushant.samurai.core.dto.ApiResponse;
import com.sushant.samurai.dto.ListUserResponse;
import com.sushant.samurai.dto.RequestUser;
import com.sushant.samurai.entity.User;
import com.sushant.samurai.exception.DuplicateException;
import com.sushant.samurai.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<ApiResponse<?>> listUsers() {
        List<User> users = userRepo.findAll();
        List<ListUserResponse> listUserResponses = new ArrayList<>();
        for (User user : users) {
            ListUserResponse listUserResponse = new ListUserResponse();
            listUserResponse.setUsername(user.getUsername());
            listUserResponse.setEmail(user.getEmail());
            listUserResponse.setFullName(user.getFullName());
            listUserResponse.setPhone(user.getPhone());
            listUserResponse.setBirthday(user.getBirthday());
            listUserResponse.setGender(user.getGender());
            listUserResponses.add(listUserResponse);
        }

        ApiResponse<?> apiResponse = new ApiResponse<>(true,"User returns successfully", 200, LocalDateTime.now(), listUserResponses);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    public User saveUser(RequestUser requestUser) {
        User user = new User();
        boolean existByEmail = userRepo.existsByEmail(requestUser.getEmail());
        if (existByEmail) {
            throw new DuplicateException("Email already exist");
        }
        boolean existByUsername = userRepo.existsByUsername(requestUser.getUsername());
        if (existByUsername) {
            throw new DuplicateException("Username already exists");
        }
        boolean existByPhone = userRepo.existsByPhone(requestUser.getPhone());
        if (existByPhone) {
            throw new DuplicateException("Phone already exists");
        }
        user.setUsername(requestUser.getUsername());
        user.setFullName(requestUser.getFullName());
        user.setPassword(requestUser.getPassword());
        user.setBirthday(requestUser.getBirthday());
        user.setPhone(requestUser.getPhone());
        user.setGender(requestUser.getGender());
        user.setEmail(requestUser.getEmail());
        return userRepo.save(user);
    }
}
