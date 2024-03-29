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
public class InspectCostChange {
    // 점검료 변경
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

    @Column(name = "sale_cost", nullable = false, unique = false)
    private String saleCost;
    // 판매가

    @Column(name = "purchase_cost", nullable = false, unique = false)
    private String purchaseCost;
    // 매입가


    @Column(name = "status", nullable = false, unique = false)
    private String status;
    // 상태

    @Column(name = "change_day", nullable = false, unique = false)
    private LocalDateTime changeDay;
    // 변경일
}
