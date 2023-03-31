package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipment {
    // 장
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    // 점검점 ID

    @Column(name = "name", nullable = false, unique = false)
    private String name;
    // 이름

    @Column(name = "image", nullable = false, unique = false)
    private String image;
    // 사진
}
