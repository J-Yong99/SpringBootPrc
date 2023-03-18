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
public class RsvInfo {
    // 예약 정보
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "car_ind_id")
    private CarInd carInd;
    // 차량 ID

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    // 점검점 ID

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    // 고객 ID

    @ManyToOne
    @JoinColumn(name = "payment_info_id")
    private PaymentInfo paymentInfo;
    // 결제 ID

    @Column(name = "status", nullable = false, unique = false)
    private String status;
    // 상태

    @Column(name = "year_date", nullable = false, unique = false)
    private LocalDateTime yearDate;
    // 날짜

    @Column(name = "inspect_time", nullable = false, unique = false)
    private Long inpectTime;
    // 점검 시간
}
