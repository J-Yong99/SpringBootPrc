package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    // 고객 앱 유저
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;
    // 시리얼 번호

//    @Column(name = "name", nullable = true, unique = false)
//    private String name;
//    // 고객 이름
//
//    @Column(name = "phone_number", nullable = true, unique = false)
//    private String phoneNumber;
//    // 고객 전화번호

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, unique = false)
    private CustomerRole role;
    // 계정 접근 권한
}
