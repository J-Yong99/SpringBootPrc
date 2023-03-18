package com.springboot.prc.jykim.utils;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OauthInfo {
    String loginId;
    String loginPw;
}