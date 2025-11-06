package com.sushant.samurai.service;

import com.sushant.samurai.dto.RequestUser;
import com.sushant.samurai.entity.User;

public interface UserService {
    User saveUser(RequestUser user);

}
