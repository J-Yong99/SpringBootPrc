package com.carzen.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerRole {
    // 본사 권한
    CUSTOMERA("ROLE_CUSTOMERA"),
    CUSTOMERB("ROLE_CUSTOMERB"),
    CUSTOMERC("ROLE_CUSTOMERC");

    private String value;
}