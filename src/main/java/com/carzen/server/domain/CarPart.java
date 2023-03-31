package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarPart {
    // 차량 부품
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "hangmok", nullable = false, unique = false)
    private String hangmok;
    // 항목

    @Column(name = "boopoom", nullable = false, unique = false)
    private String boopoom;
    // 부품
}
