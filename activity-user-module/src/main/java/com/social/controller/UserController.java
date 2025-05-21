package com.social.controller;

import com.social.model.dto.UserRequestDto;
import com.social.model.dto.UserResponseDto;
import com.social.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
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

    @PatchMapping("/status/change")
    public ResponseEntity<UserResponseDto> changeStatus(@RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(
                userService.changeStatus(userRequestDto),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/status/check")
    public ResponseEntity<UserResponseDto> activityCheck(@RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userService.checkStatus(userRequestDto), HttpStatus.OK);
    }
}
