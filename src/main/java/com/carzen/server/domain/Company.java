package com.carzen.server.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    // PK

    @Column(name = "name", nullable = false, unique = false)
    private String name;
    // 점검점 이름

    @Column(name = "is_contract", nullable = false, unique = false)
    private Boolean isContract;
    // 계약 여부

    @Column(name = "phone_number", nullable = false, unique = false)
    private String phoneNumber;
    // 점검점 전화번호

    @Column(name = "zip_code", nullable = false, unique = false)
    private String zipCode;
    // 우편번호

    @Column(name = "ji_address", nullable = false, unique = false)
    private String jiAddress;
    // 지번 주소

    @Column(name = "road_address", nullable = false, unique = false)
    private String roadAddress;
    // 도로명 주소

    @Column(name = "latitude", nullable = false, unique = false)
    private Double latitude;
    // 위도

    @Column(name = "longitude", nullable = false, unique = false)
    private Double longitude;
    // 경도

    @Column(name = "comp_reg_num", nullable = false, unique = false)
    private String compRegNum;
    // 사업자등록번호

    @Column(name = "shop_image", nullable = true, unique = false)
    private String shopImage;
    // 점검점 배경 사진

    @Column(name = "profile_image", nullable = true, unique = false)
    private String profileImage;
    // 점검점 프로필 사진

    @Column(name = "can_foreign_car", nullable = false, unique = false)
    private Boolean canForeignCar;
    // 외국 차 수리가능 여부

    @Column(name = "bank", nullable = false, unique = false)
    private String bank;
    // 은행

    @Column(name = "account_number", nullable = false, unique = false)
    private String accountNumber;
    // 계좌번호

    @Column(name = "account_owner", nullable = false, unique = false)
    private String accountOwner;
    // 예금주명


}
