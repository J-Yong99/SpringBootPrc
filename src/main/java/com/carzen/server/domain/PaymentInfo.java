package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

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

    @ManyToOne
    @JoinColumn(name = "rsv_info_id")
    private RsvInfo rsvInfo;
    // 예약 ID

    @Column(name = "cost", nullable = false, unique = false)
    private Long cost;
    // 결제 금액

    @Column(name = "status", nullable = false, unique = false)
    private String status;
    // 결제 상태

    @Column(name = "card_company", nullable = true, unique = false)
    private String cardCompany;
    // 카드사

    @Column(name = "requested_at", nullable = true, unique = false)
    private ZonedDateTime requestedAt;
    // 결제 요청 시간

    @Column(name = "approved_at", nullable = true, unique = false)
    private ZonedDateTime approvedAt;
    // 결제 승인 시간

    @Column(name = "card_num", nullable = true, unique = false)
    private String cardNum;
    // 카드 번호

    @Column(name = "order_id", nullable = false, unique = false)
    private String orderId;
    // 주문 ID

    @Column(name = "type", nullable = true, unique = false)
    private String type;
    // 결제 타입 = "카드"

    @Column(name = "payment_key", nullable = true, unique = false)
    private String paymentKey;
    // toss payment key

    @Column(name = "easy_pay_provider", nullable = true, unique = false)
    private String easyPayProvider;
    // easy pay provider

    @Column(name = "easy_pay_amount", nullable = true, unique = false)
    private String easyPayAmount;
    // easy pay amount
}
