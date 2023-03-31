package com.carzen.server.domain;
import org.springframework.security.core.GrantedAuthority;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 본사직원의 userdetails
@Setter
@Builder
public class AdminUserDetails implements UserDetails {

    // PK값
    private Long id;

    // 로그인 ID
    private String loginId;

    // 로그인 PW
    private String loginPw;

    //권한
    private String roles;

    // 사용자의 권한 목록
    private Collection<? extends GrantedAuthority> authorities;

    /*
    *  권한목록
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for(String role : roles.split(",")){
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    /*
    * loginPW
     */
    @Override
    public String getPassword() {
        return loginPw;
    }

    /*
    * loginID
     */
    @Override
    public String getUsername() {
        return loginId;
    }

    /*
    * 만료 여부
    * true : 만료안됨
    * false : 만료됨
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /*
    * 계정 잠김 여부
    * true : 안잠김
    * false : 잠김
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /*
    * 비밀번호 만료 여부
    * true : 만료 안됨
    * false : 만료됨
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*
     * 계정 활성화 여부
     * true : 만료 안됨
     * false : 만료됨
     */
    @Override
    public boolean isEnabled() {
        return (isAccountNonExpired() && isAccountNonLocked() && isCredentialsNonExpired());
    }
}
