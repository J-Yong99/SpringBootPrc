package com.carzen.server.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationRegisterDto {
    private String id;
    //pk 값
    private Long carIndId;
    //차량 pk 값
    private Long companyId;
    //점검점 pk 값
    private LocalDate yearDate;
    //날짜
    private Long inspectTime;
    //점검 시간
    private String customerName;
    // 고객 이름
    private String customerPhoneNumber;
    // 고객 전화번호
}
