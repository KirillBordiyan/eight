package com.social.controller;

import com.social.jwt.JwtRequest;
import com.social.model.User;
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

    @PutMapping("/disable/{userId}")
//    @PreAuthorize("@ExpressionName.methodForAdminOnly(#jwt)")
    public ResponseEntity<User> disableUser(@RequestParam UUID userId,
                                            @RequestHeader JwtRequest jwt) {
        return new ResponseEntity<>(
                userService.disable(userId),
                HttpStatus.ACCEPTED
        );
    }

    @PutMapping("/activate/{userId}")
//    @PreAuthorize("@ExpressionName.methodForAdminOnly(#jwt)")
    public ResponseEntity<User> activateUser(@RequestParam UUID userId,
                                             @RequestHeader JwtRequest jwt) {
        return new ResponseEntity<>(
                userService.activate(userId),
                HttpStatus.ACCEPTED
        );
    }
}
