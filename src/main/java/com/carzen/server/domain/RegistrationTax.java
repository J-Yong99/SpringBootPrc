package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationTax {
    // 리포트
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "region", nullable = false, unique = false)
    private String region;
    // 지역

    @Column(name = "acq_rate", nullable = false, unique = false)
    private Long acqRate;
    // 취득세율

    @Column(name = "gong_mae_rate", nullable = false, unique = false)
    private Long gongMaeRate;
    // 공채 매입율

    @Column(name = "gong_hal_rate", nullable = false, unique = false)
    private Long gongHalRate;
    // 공채 할인율

    @Column(name = "jung_ji", nullable = false, unique = false)
    private Long jungJi;
    // 증지대

    @Column(name = "in_ji", nullable = false, unique = false)
    private Long inJi;
    // 인지대





}
