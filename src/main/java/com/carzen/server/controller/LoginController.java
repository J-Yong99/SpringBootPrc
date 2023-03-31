package com.carzen.server.controller;

import com.carzen.server.domain.HqUser;
import com.carzen.server.dto.LoginRequestDto;
import com.carzen.server.service.HqUserService;
import com.carzen.server.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {
    private final HqUserService hqUserService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtils jwtTokenUtils;
    @Autowired
    LoginController(HqUserService hqUserService, PasswordEncoder passwordEncoder, JwtTokenUtils jwtTokenUtils){
        this.hqUserService = hqUserService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequestDto loginRequestDto
    ){
        try{
            HqUser user = hqUserService.findByloginId(loginRequestDto.getLoginId());
            if (!passwordEncoder.matches(loginRequestDto.getLoginPw(), user.getLoginPw())){
                throw new Exception("PW not correct!");
            }
            else{
                hqUserService.saveToken(user, jwtTokenUtils.generateRefreshToken());
                return jwtTokenUtils.generateAccessToken(user.getLoginId(), "HQ");
            }
        }catch (Exception e) {
            log.error("post /login error occured" + e);
            return null;
        }
    }
}
