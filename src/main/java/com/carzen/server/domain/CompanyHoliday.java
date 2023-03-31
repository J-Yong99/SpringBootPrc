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
public class CompanyHoliday {
    // 특수 휴일
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    // 점검점 ID

    @Column(name = "year_date", nullable = false, unique = false)
    private LocalDateTime yearDate;
    // 년/월/일

    @Column(name = "time1", nullable = false, unique = false)
    private Boolean time1;
    // 점검시간1

    @Column(name = "time2", nullable = false, unique = false)
    private Boolean time2;
    // 점검시간2

    @Column(name = "time3", nullable = false, unique = false)
    private Boolean time3;
    // 점검시간3

    @Column(name = "time4", nullable = false, unique = false)
    private Boolean time4;
    // 점검시간4

    @Column(name = "time5", nullable = false, unique = false)
    private Boolean time5;
    // 점검시간5

    @Column(name = "time6", nullable = false, unique = false)
    private Boolean time6;
    // 점검시간6
}
