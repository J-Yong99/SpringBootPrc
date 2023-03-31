package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    // 차
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "car_type_id")
    private CarType carType;
    // 차종류

    @Column(name = "byunsok_type", nullable = false, unique = false)
    private String byunsokType;
    // 변속기 종류

    @Column(name = "onedong_type", nullable = false, unique = false)
    private String onedongType;
    // 원동기 형식

    @Column(name = "name", nullable = false, unique = false)
    private String name;
    // 차량 모델명

    @Column(name = "wheel_type", nullable = false, unique = false)
    private String wheelType;
    // 구륜

    @Column(name = "oil_type", nullable = false, unique = false)
    private String oilType;
    // 유종
}
