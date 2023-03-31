package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImproveCostChange {
    // 품질개선정비료 변경
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "hq_user_id")
    private HqUser hqUser;
    // 본사 ID

    @ManyToOne
    @JoinColumn(name = "car_type_id")
    private CarType carType;
    // 차종류

    @ManyToOne
    @JoinColumn(name = "car_part_id")
    private CarPart carPart;
    // 차부품

    @Column(name = "cost", nullable = false, unique = false)
    private String cost;
    // 가격

    @Column(name = "status", nullable = false, unique = false)
    private String status;
    // 상태

    @Column(name = "change_day", nullable = false, unique = false)
    private LocalDateTime changeDay;
    // 변경일
}
