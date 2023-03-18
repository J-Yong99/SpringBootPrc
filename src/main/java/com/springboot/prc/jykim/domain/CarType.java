package com.springboot.prc.jykim.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarType {
    // 차종
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "is_korean", nullable = false, unique = false)
    private Boolean isKorean;
    // 국산유무

    @Column(name = "name", nullable = false, unique = false)
    private String name;
    // 차종명
}
