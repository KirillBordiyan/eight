package com.social.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private UUID userId;
    private boolean isActive;
}
