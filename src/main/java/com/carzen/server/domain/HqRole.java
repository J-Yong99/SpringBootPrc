package com.carzen.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HqRole {
    // 본사 권한
    HQA("ROLE_HQA"),
    HQB("ROLE_HQB"),
    HQC("ROLE_HQC");

    private final String value;
}