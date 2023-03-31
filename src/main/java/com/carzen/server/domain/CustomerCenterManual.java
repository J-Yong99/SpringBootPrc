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
public class CustomerCenterManual {
    // 고객센터 메뉴얼
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "hq_user_id")
    private HqUser hqUser;
    // 본사 ID

    @Column(name = "title", nullable = false, unique = false)
    private String title;
    // 메뉴얼 제목

    @Column(name = "contents", nullable = false, unique = false)
    private String contents;
    // 메뉴얼 내용

    @Column(name = "announced_date", nullable = false, unique = false)
    private LocalDateTime announcedDate;
    // 공지 날짜
}
