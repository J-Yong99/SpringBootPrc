package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionalAgreement {
    // 선택 약관 동의
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
    // 약관 ID

    @ManyToOne
    @JoinColumn(name = "rsv_info_id")
    private RsvInfo rsvInfo;
    // 예약 ID

    @Column(name = "is_agree", nullable = false, unique = false)
    private Boolean isAgree;
    // 약관 동의 여부

}
