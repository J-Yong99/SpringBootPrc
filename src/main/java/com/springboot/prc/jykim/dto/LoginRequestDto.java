package com.springboot.prc.jykim.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {
    private String loginId;
    private String loginPw;
}
