package com.carzen.server.dto;

import com.carzen.server.domain.HqRole;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HqUserRegisterDto {
    // hqUserRegisterDto
    private String loginId;
    private String loginPw;
    private String phoneNumber;
    private String name;
    private String email;
    private List<HqRole> roles;
}
