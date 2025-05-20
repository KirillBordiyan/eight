package com.social.service;

import com.social.model.User;

import java.util.UUID;

public interface UserService {
    User disable(UUID userId);
    User activate(UUID userId);
}
