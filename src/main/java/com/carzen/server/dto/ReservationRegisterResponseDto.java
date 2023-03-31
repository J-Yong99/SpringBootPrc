package com.carzen.server.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRegisterResponseDto {
    private Long id;
    //pk 값
    private Long carIndId;
    //차량 pk 값
    private Long companyId;
    //점검점 pk 값
    private String yearDate;
    //날짜
    private Long inspectTime;
    //점검 시간
    private String customerName;
    // 고객 이름
    private String customerPhoneNumber;
    // 고객 전화번호
}
