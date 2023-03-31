package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCenterInquiries {
    // 고객센터 문의사항
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "hq_user_id")
    private HqUser hqUser;
    // 본사 ID

    @ManyToOne(optional = true)
    @JoinColumn(name = "rsv_id")
    private RsvInfo rsvInfo;
    // 예약 ID nullable

    @ManyToOne(optional = true)
    @JoinColumn(name = "company_id")
    private Company company;
    // 점검점 ID nullable

    @Column(name = "announced_date", nullable = false, unique = false)
    private LocalDateTime announcedDate;
    // 문의 날짜시간

    @Column(name = "rsv_date", nullable = true, unique = false)
    private LocalDateTime rsvDate;
    // 예약/점검 일자

    @Column(name = "contents", nullable = false, unique = false)
    private String contents;
    // 문의 내용

    @Column(name = "type", nullable = false, unique = false)
    private String type;
    // 문의 유형

    @Column(name = "customer_name", nullable = true, unique = false)
    private String customerName;
    // 고객 이름

    @Column(name = "hq_part", nullable = false, unique = false)
    private String hqPart;
    // 처리 부서

    @Column(name = "solution", nullable = true, unique = false)
    private String solution;
    // 처리내용

    @Column(name = "answer_solution", nullable = false, unique = false)
    private String answerSolution;
    // 답변/해결

    @Column(name = "phone_number", nullable = true, unique = false)
    private String phoneNumber;
    // 전화번호
}
