package com.carzen.server.utils;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OauthInfo {
    String iss;
    String sub;
}