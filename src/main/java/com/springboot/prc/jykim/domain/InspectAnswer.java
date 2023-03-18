package com.springboot.prc.jykim.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InspectAnswer {
    // 점검 항목 선택지
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "inspect_question_id")
    private InspectQuestion inspectQuestion;
    // 점검 항목 ID

    @Column(name = "contents", nullable = false, unique = false)
    private String contents;
    // 선택지 내용

    @Column(name = "is_default", nullable = false, unique = false)
    private Boolean isDefault;
    // 디폴트 유무

}
