package com.social.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum Status implements Serializable {
    ACTIVE,
    DIACTIVATED;
}
