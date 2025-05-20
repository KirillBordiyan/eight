package com.social.service;

import com.social.mappers.UserMapper;
import com.social.model.User;
import com.social.model.dto.UserRequestDto;
import com.social.model.dto.UserResponseDto;
import com.social.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto create(UserRequestDto userRequestDto) {
        try {
            User created = userMapper.userRequestToUserEntity(userRequestDto);
            repository.save(created);
            return userMapper.userEntityToResponse(created);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public UserResponseDto disable(UUID userId) {
        User user = repository.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException("No such user found: " + userId));
        if (user.isActive()) {
            user.setActive(false);
        }

        return userMapper.userEntityToResponse(repository.save(user));
    }

    @Override
    @Transactional
    public UserResponseDto activate(UUID userId) {
        User user = repository.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException("No such user found: " + userId));
        if (!user.isActive()) {
            user.setActive(true);
        }
        return userMapper.userEntityToResponse(repository.save(user));
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean isActive(UUID userId) {
        User user = repository.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException("No such user found: " + userId));

        return user.isActive();
    }
}
