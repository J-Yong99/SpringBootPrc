package com.springboot.prc.jykim.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarInd {
    // 차량
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    // 차 ID

    @Column(name = "year", nullable = false, unique = false)
    private Long year;
    // 연식

    @Column(name = "car_form_num", nullable = false, unique = false)
    private String carFormNum;
    // 차대번호

    @Column(name = "car_num", nullable = false, unique = false)
    private String carNum;
    // 차량번

    @Column(name = "reg_date", nullable = false, unique = false)
    private LocalDateTime regDate;
    // 최초 등록일

}
