package com.sushant.samurai.service;

import com.sushant.samurai.dto.RequestUser;
import com.sushant.samurai.entity.User;
import com.sushant.samurai.exception.DuplicateException;
import com.sushant.samurai.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

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
