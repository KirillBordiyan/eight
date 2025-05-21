package com.social.service;

import com.social.model.User;
import com.social.model.dto.UserRequestDto;
import com.social.model.dto.UserResponseDto;

import java.util.UUID;

public interface UserService {
    UserResponseDto create(UserRequestDto requestDto);
    UserResponseDto disable(UUID userId);
    UserResponseDto activate(UUID userId);
    Boolean isActive(UUID userId);
}
