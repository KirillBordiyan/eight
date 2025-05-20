package com.social.jwt;

import lombok.Getter;

@Getter
public class JwtRequest {
    private String access;
    private String refresh;
}
