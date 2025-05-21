package com.social.model.dto;

import com.social.model.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private UUID userId;
    private Status status;
    private LocalDateTime lastDateChange;
}
