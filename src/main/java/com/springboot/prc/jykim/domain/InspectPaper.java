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
public class InspectPaper {
    // 점검지
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "created_date", nullable = false, unique = false)
    private LocalDateTime createdDate;
    // 생성일
}
