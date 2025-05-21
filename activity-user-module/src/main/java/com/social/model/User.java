package com.social.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "bank_user_activity")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "active_status", nullable = false)
    private Status status;

    @Column(name = "last_date_change")
    private LocalDateTime lastDateChange;
}
