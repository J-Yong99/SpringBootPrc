package com.springboot.prc.jykim.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InspectCost {
    // 점검료
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
    // 차종료

    @Column(name = "sale_cost", nullable = false, unique = false)
    private String saleCost;
    // 판매가

    @Column(name = "purchase_cost", nullable = false, unique = false)
    private String purchaseCost;
    // 매입가
}
