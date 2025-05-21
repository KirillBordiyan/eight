package com.social.service;

import com.social.model.dto.UserRequestDto;
import com.social.model.dto.UserResponseDto;

public interface UserService {
    UserResponseDto create(UserRequestDto requestDto);

    UserResponseDto changeStatus(UserRequestDto requestDto);

    UserResponseDto checkStatus(UserRequestDto requestDto);
}
