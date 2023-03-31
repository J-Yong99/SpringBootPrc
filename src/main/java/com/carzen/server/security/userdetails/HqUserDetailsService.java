package com.carzen.server.security.userdetails;

import com.carzen.server.domain.HqUser;
import com.carzen.server.repository.HqUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HqUserDetailsService implements UserDetailsService {
    @Autowired
    public HqUserDetailsService(HqUserRepository hqUserRepository) {
        this.hqUserRepository = hqUserRepository;
    }

    private HqUserRepository hqUserRepository;
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        HqUser hqUser = hqUserRepository.findByLoginId(loginId).orElseThrow(() -> new UsernameNotFoundException("HqUserDetailsService : can not find loginId : " + loginId));
        hqUser.setLstDate(LocalDateTime.now());
        hqUserRepository.save(hqUser);
        return new HqUserDetails(
                hqUser.getId(),
                hqUser.getName(),
                hqUser.getLoginId(),
                hqUser.getLoginPw(),
                hqUser.getEmail(),
                hqUser.getPhone_number(),
                hqUser.getRgtDate(),
                hqUser.getLstDate(),
                hqUser.getRoles()
        );
    }
}
