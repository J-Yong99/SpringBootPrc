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
public class Report {
    // 리포트
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "inspect_paper_id")
    private InspectPaper inspectPaper;
    // 점검지 ID

    @Column(name = "expire_date", nullable = false, unique = false)
    private LocalDate expireDate;
    // 보증기한 = 만료일

    @Column(name = "fix_count", nullable = false, unique = false)
    private Long fixCount;
    // 수정횟수

    @Column(name = "url", nullable = true, unique = false)
    private String url;
    // url

    @Column(name = "max_fix_count", nullable = false, unique = false)
    private Long maxFixCount;
    // 최대 수정 횟수

    @Column(name = "report_num", nullable = false, unique = false)
    private Long reportNum;
    // 리포트 번호

}
