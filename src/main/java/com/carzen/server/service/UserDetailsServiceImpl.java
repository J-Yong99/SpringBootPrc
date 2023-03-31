package com.carzen.server.service;

import com.carzen.server.domain.AdminUserDetails;
import com.carzen.server.repository.HqUserRepository;
import com.carzen.server.domain.HqUser;
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
