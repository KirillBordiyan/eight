package com.social.service;

import com.social.mappers.UserMapper;
import com.social.model.User;
import com.social.model.dto.UserRequestDto;
import com.social.model.dto.UserResponseDto;
import com.social.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto create(UserRequestDto userRequestDto) {
        try {
            User created = userMapper.userRequestToUserEntity(userRequestDto);
            created.setLastDateChange(LocalDateTime.now());
            repository.save(created);
            return userMapper.userEntityToResponse(created);
        } catch (Exception e) {
            throw new IllegalStateException("User already exist: " + userRequestDto.getUserId());
        }
    }

    @Override
    @Transactional
    public UserResponseDto changeStatus(UserRequestDto requestDto) {
        User user = repository.getUserByUserId(requestDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("No such user found in status change process: " + requestDto.getUserId()));
        if (user.getStatus() == requestDto.getStatus()) {
            throw new IllegalArgumentException("User activity already: " + user.getStatus());
        } else {
            user.setStatus(requestDto.getStatus());
            user.setLastDateChange(LocalDateTime.now());
            return userMapper.userEntityToResponse(repository.save(user));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto checkStatus(UserRequestDto requestDto) {
        User user = repository.getUserByUserId(requestDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("No such user found in search process: " + requestDto.getUserId()));
//        User user = repository.getUserByUserId(requestDto)
//                .orElseThrow(() -> new NoSuchElementException("No such user found in search process: " + requestDto));
        return userMapper.userEntityToResponse(user);
    }
}
