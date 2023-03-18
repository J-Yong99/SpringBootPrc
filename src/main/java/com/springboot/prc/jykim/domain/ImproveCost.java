package com.springboot.prc.jykim.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImproveCost {
    // 품질개선정비료
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
}
