package com.carzen.server.dto.car;

public class getCarTaxResponseDto {
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
}
