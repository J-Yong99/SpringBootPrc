package com.carzen.server.security.userdetails;

import com.carzen.server.domain.HqRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class HqUserDetails implements UserDetails {

    private Long id;
    //pk 값

    private String name;
    // 직원 이름

    private String loginId;
    // 직원 로그인 ID

    private String loginPw;
    // 직원 로그인 PW

    private String email;
    // 직원 이메일

    private String phone_number;
    // 직원 전화번호부

    private LocalDateTime rgtDate;
    // 계정 등록일

    private LocalDateTime lstDate;
    // 계정 마지막 접속시간

    private List<HqRole> roles;

    private Collection<? extends GrantedAuthority> authorities;

    public HqUserDetails(Long id, String name, String loginId, String loginPw, String email, String phone_number, LocalDateTime rgtDate, LocalDateTime lstDate, List<HqRole> roles) {
        this.id = id;
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.email = email;
        this.phone_number = phone_number;
        this.rgtDate = rgtDate;
        this.lstDate = lstDate;
        this.roles = roles;
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (HqRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getValue()));
        }
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
