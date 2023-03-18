package com.springboot.prc.jykim.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policy {
    // 약관
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "title", nullable = false, unique = false)
    private String title;
    // 약관 제목

    @Column(name = "contents", nullable = false, unique = false)
    private String contents;
    // 약관 내용

    @Column(name = "seq", nullable = false, unique = false)
    private Long seq;
    // 약관 순서
}
