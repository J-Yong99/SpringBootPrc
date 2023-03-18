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

    @Column(name = "rsv_id", nullable = true, unique = false)
    private Long rscId;
    // 예약 ID nullable

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    // 점검점 ID

    @Column(name = "announced_date", nullable = false, unique = false)
    private LocalDateTime announcedDate;
    // 문의 날짜시간

    @Column(name = "contents", nullable = false, unique = false)
    private String contents;
    // 문의 내용

    @Column(name = "type", nullable = false, unique = false)
    private String type;
    // 문의 유형

    @Column(name = "customer_name", nullable = true, unique = false)
    private String customerName;
    // 고객 이름

    @Column(name = "hq_part", nullable = true, unique = false)
    private String hqPart;
    // 처리 부서

    @Column(name = "solution", nullable = true, unique = false)
    private String solution;
    // 처리내용
}
