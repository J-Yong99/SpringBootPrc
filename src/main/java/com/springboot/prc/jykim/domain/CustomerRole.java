package com.springboot.prc.jykim.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerRole {
    // 본사 권한
    A("ROLE_A"),
    B("ROLE_B"),
    C("ROLE_C");

    private String value;
}