package com.social.service;

import com.social.model.User;
import com.social.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    @Override
    public User disable(UUID userId) {
        User user = repository.getUserById(userId)
                .orElseThrow();
        if(user.isActive()){
            user.setActive(false);
        }
        return repository.save(user);
    }

    @Override
    public User activate(UUID userId) {
        User user = repository.getUserById(userId)
                .orElseThrow();
        if(!user.isActive()){
            user.setActive(true);
        }
        return repository.save(user);
    }
}
