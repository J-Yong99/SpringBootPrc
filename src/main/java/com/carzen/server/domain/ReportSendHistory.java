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
public class ReportSendHistory {
    // 리포트 전송 내역
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
    // 리포트 ID

    @ManyToOne
    @JoinColumn(name = "hq_user_id")
    private HqUser hqUser;
    // 본사 ID

    @Column(name = "send_date", nullable = false, unique = false)
    private LocalDateTime sendDate;
    // 전송일자

    @Column(name = "phone_number", nullable = false, unique = false)
    private String phoneNumber;
    // 전송 번호

    @Column(name = "method", nullable = false, unique = false)
    private String method;
    // 전송방법

    @Column(name = "status", nullable = false, unique = false)
    private String status;
    // 상태
}
