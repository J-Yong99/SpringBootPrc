package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "rsv_status", nullable = false, unique = false)
    private String rsvStatus;
    // 예약 상태

    @Column(name = "ins_status", nullable = false, unique = false)
    private String insStatus;
    // 점검 상태

    @Column(name = "year_date", nullable = false, unique = false)
    private LocalDate yearDate;
    // 날짜

    @Column(name = "inspect_time", nullable = false, unique = false)
    private Long inpectTime;
    // 점검 시간

    @Column(name = "customer_name", nullable = false, unique = false)
    private String customerName;
    // 고객 이름

    @Column(name = "customer_phone_number", nullable = false, unique = false)
    private String customerPhoneNumber;
    // 고객 전화번호

}
