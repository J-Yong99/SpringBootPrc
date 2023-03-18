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
public class DeviceHistory {
    // 기기 히스토리
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "hq_user_id")
    private HqUser hqUser;
    // 본사 ID

    @Column(name = "status_change", nullable = true, unique = false)
    private String statusChange;
    // 상태변화

    @Column(name = "comp_change", nullable = true, unique = false)
    private String compChange;
    // 점검점 변화


    @Column(name = "serial_number", nullable = false, unique = false)
    private String serialNumber;
    // 시리얼 번호

    @Column(name = "year_day", nullable = false, unique = false)
    private LocalDateTime yearDay;
    // 날짜
}
