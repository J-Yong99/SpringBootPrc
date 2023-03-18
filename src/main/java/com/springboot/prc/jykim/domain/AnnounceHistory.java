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
public class AnnounceHistory {
    // 본사 공지 히스토리
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "title", nullable = false, unique = false)
    private String title;
    // 공지 제목

    @Column(name = "contents", nullable = false, unique = false)
    private String contents;
    // 공지 내용

    @Column(name = "announced_date", nullable = false, unique = false)
    private LocalDateTime announcedDate;
    // 공지 날짜

    @ManyToOne
    @JoinColumn(name = "hq_user_id")
    private HqUser hqUser;
    // 본사 ID

    @Column(name = "status", nullable = false, unique = false)
    private String status;
    // 공지 상태
}
