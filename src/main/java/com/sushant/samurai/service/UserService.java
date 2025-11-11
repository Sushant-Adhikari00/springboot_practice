package com.sushant.samurai.service;

import com.sushant.samurai.core.dto.ApiResponse;
import com.sushant.samurai.core.dto.PaginationDto;
import com.sushant.samurai.dto.RequestUser;
import com.sushant.samurai.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User saveUser(RequestUser user);
    ResponseEntity<ApiResponse<?>> listUsers(PaginationDto pagination);

}
