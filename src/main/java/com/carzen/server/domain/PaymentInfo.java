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
public class PaymentInfo {
    // 결제 정보
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "cost", nullable = false, unique = false)
    private Long cost;
    // 결제 금액

    @Column(name = "status", nullable = false, unique = false)
    private String status;
    // 결제 상태

    @Column(name = "card_company", nullable = false, unique = false)
    private String cardCompany;
    // 카드

    @Column(name = "year_date", nullable = false, unique = false)
    private LocalDateTime yearDate;
    // 결제 날짜

    @Column(name = "card_num", nullable = false, unique = false)
    private String cardNum;
    // 카드 번호

}
