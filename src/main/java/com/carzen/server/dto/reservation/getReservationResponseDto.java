package com.carzen.server.dto.reservation;

public class getReservationResponseDto {
    private String rsvId;

    private String companyId;

    //차량번호
    private String carNumber;

    //차종
    private String carType;

    //유종
    private String fuelType;

    //구동방식
    private String drivingMethod;

    //연식
    private String carYear;

    //차대번호
    private String vin;

    //고객 전화번호
    private String customerPhoneNumber;

    //예약일시
    private String rsvDate;

    //점검상태
    private String inspectStatus;

    //예약상태
    private String rsvStatus;

    //결제상태
    private String payStatus;

    //결제일시
    private String payDate;

    //결제취소일시
    private String payCancelDate;

    //결제 금액
    private String payAmount;
}
