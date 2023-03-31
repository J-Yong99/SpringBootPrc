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
public class InspectPaper {
    // 점검지
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "rsv_info_id")
    private RsvInfo rsvInfo;
    // 예약 정보 ID

    @Column(name = "created_date", nullable = false, unique = false)
    private LocalDateTime createdDate;
    // 생성일

    @Column(name = "total_num", nullable = true, unique = false)
    private Long totalNum;
    // 전체항목수

    @Column(name = "good_num", nullable = true, unique = false)
    private Long goodNum;
    // 양호항목수

    @Column(name = "bad_num", nullable = true, unique = false)
    private Long badNum;
    // 불량항목수
}
