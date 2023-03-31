package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InspectPaperAnswers {
    // 점검지 - 점검 항목 선택지
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @ManyToOne
    @JoinColumn(name = "inspect_paper_id")
    private InspectPaper inspectPaper;
    // 점검지 ID

    @ManyToOne
    @JoinColumn(name = "inspect_answer_id")
    private InspectAnswer inspectAnswer;
    // 점검 항목 선택지 ID
}
