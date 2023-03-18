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
public class DeviceReset {
    // 기기 초기화 요청
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
    // 기기 ID

    @Column(name = "date_time", nullable = false, unique = false)
    private LocalDateTime dateTime;
    // 날짜 시간

    @Column(name = "description", nullable = true, unique = false)
    private String description;
    // 비고
}
