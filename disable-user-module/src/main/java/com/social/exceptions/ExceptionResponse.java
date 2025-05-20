package com.social.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private String error;

    public ExceptionResponse(String message) {
        this.message = message;
    }
}
