package com.carzen.server.dto.car;

public class getCarResponseDto {
    private String carId;

    private String carName;

    private String carNumber;

    private String carType;

    private String cc;

    private String fuelType;

    private String carImage;

    private String drivingMethod;

    private String carYear;

    private String mission; // 자동차 미션

    private String fuelEfficiency;

    private String battery;

    private String tireFront;

    private String tireRear;

    private String checkDeadline; // 정기 검사 기한

    private String firstRegistrationDate; // 최초 등록일

    private String carPrice;

    private String secondHandCarPrice; // 중고차 시세

    private String ownerChangeCount; // 소유자 변경 횟수

    //용도 변경 이력 배열
    private String[] purposeChangeHistory;

    private String recallDate;

    //자동차세 배열
    private String[] carTax;

    //지역
    private String region;

    //취득세율
    private String acquisitionTaxRate;

    //취득세
    private String acquisitionTax;

    //공채매입율
    private String publicAuctionPurchaseRate;

    //공채매입액
    private String publicAuctionPurchaseAmount;

    //공채할인율
    private String publicAuctionDiscountRate;

    //공채할인액
    private String publicAuctionDiscountAmount;

    //증지대
    private String increaseAmount;

    //인지대
    private String recognitionAmount;

    //취등록세 계
    private String totalAcquisitionRegistrationTax;

    //보험료총액
    private String totalInsuranceAmount;

    //보험처리내역
    private String[] insuranceHistory;


}
