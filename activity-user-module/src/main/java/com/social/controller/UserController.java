package com.social.controller;

import com.social.model.dto.UserRequestDto;
import com.social.model.dto.UserResponseDto;
import com.social.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(
                userService.create(userRequestDto),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/disable/{userId}")
    public ResponseEntity<UserResponseDto> disableUser(@PathVariable UUID userId) {
        return new ResponseEntity<>(
                userService.disable(userId),
                HttpStatus.ACCEPTED
        );
    }

    @PutMapping("/activate/{userId}")
    public ResponseEntity<UserResponseDto> activateUser(@PathVariable UUID userId) {
        return new ResponseEntity<>(
                userService.activate(userId),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/check-active")
    public ResponseEntity<Boolean> isActive(@PathVariable UUID userId) {
        return new ResponseEntity<>(userService.isActive(userId), HttpStatus.OK);
    }
}
