package com.carzen.server.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRegisterDto {
    private Long deviceId;

    private String name;

    private Boolean isContract;

    private String phoneNumber;

    private String zipCode;

    private String jiAddress;

    private String roadAddress;

    private Double latitude;

    private Double longitude;

    private String compRegNum;

    private String shopImage;

    private String profileImage;

    private Boolean canForeignCar;

    private String bank;

    private String accountNumber;

    private String accountOwner;
}
