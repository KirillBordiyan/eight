package com.social.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
public class User {
    private UUID userId;
    private boolean isActive;
}
