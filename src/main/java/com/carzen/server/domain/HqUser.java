package com.carzen.server.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HqUser {
    // 본사 직원 계정
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "name", nullable = false, unique = false)
    private String name;
    // 직원 이름

    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;
    // 직원 로그인 ID

    @Column(name = "login_pw", nullable = false, unique = false)
    private String loginPw;
    // 직원 로그인 PW

    @Column(name = "email", nullable = true, unique = false)
    private String email;
    // 직원 이메일

    @Column(name = "phone_number", nullable = true, unique = false)
    private String phone_number;
    // 직원 전화번호부


    @Column(name = "rgt_date", nullable = true, unique = false)
    private LocalDateTime rgtDate;
    // 계정 등록일


    @Column(name = "lst_date", nullable = true, unique = false)
    private LocalDateTime lstDate;
    // 계정 마지막 접속시간

    @ElementCollection(targetClass = HqRole.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "roles", nullable = false, unique = false)
    private List<HqRole> roles;
    // 계정 접근 권한

    @Column(name = "refresh_token", nullable = true, unique = false)
    private String refreshToken;
    // 리프레쉬 토큰
}

