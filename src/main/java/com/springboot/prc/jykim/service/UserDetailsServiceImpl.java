package com.springboot.prc.jykim.service;

import com.springboot.prc.jykim.domain.HqUser;
import com.springboot.prc.jykim.domain.AdminUserDetails;
import com.springboot.prc.jykim.repository.HqUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final HqUserRepository hqUserRepository;

    @Override
    public AdminUserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        HqUser user = hqUserRepository.findByLoginId(loginId).orElseThrow(
                () -> new UsernameNotFoundException("user loginId not found!" + loginId)
        );

        return AdminUserDetails.builder()
                .id(user.getId())
                .loginId(user.getLoginId())
                .loginPw(user.getLoginPw())
                .build()
                ;
    }
}
