package com.carzen.server.dto.reservation;

public class postReservationResponseDto {
    //고객 ID
    private String customerId;

    //예약 ID
    private String rsvId;

    //점검점 ID
    private String companyId;

    //예약 상태
    private String rsvStatus;

    //점검 상태
    private String inspectStatus;

    //예약 일시
    private String rsvDate;

    //결제 일시
    private String payDate;

    //결제 금액
    private String payAmount;

    //차량 번호
    private String carNumber;

    //차종
    private String carType;

    //차량명
    private String carName;

    //유종
    private String fuelType;

    //구동방식
    private String driveMethod;

    //연식
    private String carYear;

    //고객 전화번호
    private String customerPhoneNumber;


}
