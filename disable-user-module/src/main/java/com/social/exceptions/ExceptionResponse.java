package com.social.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private Map<String, String> errors;

    public ExceptionResponse(String message) {
        this.message = message;
    }
}
