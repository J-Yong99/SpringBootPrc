package com.springboot.prc.jykim.service;

import com.springboot.prc.jykim.domain.HqUser;
import com.springboot.prc.jykim.dto.AdminUserRegisterDto;
import com.springboot.prc.jykim.repository.HqUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class HqUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private HqUserRepository hqUserRepository;

    public List<HqUser> findUsers() throws Exception {
        List<HqUser> hqUsers = hqUserRepository.findAll();
        if(Objects.isNull(hqUsers) || hqUsers.isEmpty()){
            throw new Exception("user empty");
        }
        return hqUsers;
    }진

    public void join(AdminUserRegisterDto request) throws Exception{
        HqUser HQUser = HqUser.builder()
                .loginId(request.getLoginId())
                .loginPw(passwordEncoder.encode(request.getLoginPw()))
                .email(request.getEmail())
                .phone_number(request.getPhoneNumber())
                .name(request.getName())
                .rgtDate(request.getRgtDate())
                .lstDate(request.getLstDate())
                .roles(request.getRoles())
                .build();
        hqUserRepository.save(HQUser);
    }

    public HqUser findByloginId(String loginId) throws Exception {
        return hqUserRepository.findByLoginId(loginId).orElseThrow(() -> new Exception("error find by loginId"));
    }

    public void saveToken(HqUser user, String refreshToken){
        user.setRefreshToken(refreshToken);
        hqUserRepository.save(user);
    }
}
