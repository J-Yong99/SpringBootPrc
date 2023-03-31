package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    // 기기
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    // 점검점 ID

    @Column(name = "serial_number", nullable = false, unique = false)
    private String serialNumber;
    // 시리얼번호

    @Column(name = "status", nullable = false, unique = false)
    private String status;
    // 기기 상태

    @Column(name = "description", nullable = true, unique = false)
    private String description;
    // 비고

    @Column(name = "certificate_code", nullable = true, unique = false)
    private String certificateCode;
    // 인증번호
}
