package com.springboot.prc.jykim.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InspectQuestion {
    // 점검지 양식
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "car_type_id")
    private CarType carType;
    // 차종 ID

    @Column(name = "contents", nullable = false, unique = false)
    private String contents;
    // 내용

    @Column(name = "big_category", nullable = false, unique = false)
    private String BigCategory;
    // 대분류

    @Column(name = "mid_category", nullable = false, unique = false)
    private String midCategory;
    // 중분류

    @Column(name = "small_category", nullable = false, unique = false)
    private String smallCategory;
    // 소분류

    @Column(name = "category_type", nullable = false, unique = false)
    private String categoryType;
    // 항목 타입

    @Column(name = "wheel_type", nullable = false, unique = false)
    private String wheelType;
    // 구륜

    @Column(name = "oil_type", nullable = false, unique = false)
    private String oilType;
    // 유종
}
