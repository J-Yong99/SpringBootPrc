package com.carzen.server.dto.reservation;

public class getReservationRequestDto {
    //조회 시작일
    private String startDate;

    //조회 끝일
    private String endDate;

    //예약 ID
    private String rsvId;

    //점검점 ID
    private String companyId;

    //예약 상태
    private String rsvStatus;

    //점검 상태
    private String inspectStatus;

    //차량번호
    private String carNumber;

    //차량명
    private String carName;

    //고객 전화번호
    private String customerPhoneNumber;

}
