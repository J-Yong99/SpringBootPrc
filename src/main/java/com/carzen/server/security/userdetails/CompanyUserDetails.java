package com.carzen.server.security.userdetails;

import com.carzen.server.domain.CustomerRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public class CompanyUserDetails implements UserDetails {
    private Long id;
    //pk 값

    private String name;
    // 점검점 이름

    private Boolean isContract;
    // 계약 여부

    private String phone_number;
    // 점검점 전화번호

    private String zipCode;
    // 우편번호

    private String jiAddress;
    // 지번 주소

    private String roadAddress;
    // 도로명 주소

    private Double latitude;
    // 위도

    private Double longitude;
    // 경도

    private String compRegNum;
    // 사업자등록번호

    private String shopImage;
    // 점검점 배경 사진

    private String profileImage;
    // 점검점 프로필 사진

    private Boolean canForeignCar;
    // 외국 차 수리가능 여부

    private String bank;
    // 은행

    private String accountNumber;
    // 계좌번호

    private String accountOwner;
    // 예금주명

    private Collection<? extends GrantedAuthority> authorities;

    public CompanyUserDetails(Long id, String name, Boolean isContract, String phone_number, String zipCode, String jiAddress, String roadAddress, Double latitude, Double longtitude, String compRegNum, String shopImage, String profileImage, Boolean canForeignCar, String bank, String accountNumber, String accountOwner) {
        this.id = id;
        this.name = name;
        this.isContract = isContract;
        this.phone_number = phone_number;
        this.zipCode = zipCode;
        this.jiAddress = jiAddress;
        this.roadAddress = roadAddress;
        this.latitude = latitude;
        this.longitude = longtitude;
        this.compRegNum = compRegNum;
        this.shopImage = shopImage;
        this.profileImage = profileImage;
        this.canForeignCar = canForeignCar;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_COMPANY"));
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return (isAccountNonExpired() && isAccountNonLocked() && isCredentialsNonExpired());
    }
}
