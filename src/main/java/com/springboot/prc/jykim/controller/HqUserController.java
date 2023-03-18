package com.springboot.prc.jykim.controller;

import com.springboot.prc.jykim.dto.AdminUserRegisterDto;
import com.springboot.prc.jykim.service.HqUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class HqUserController {
    private final HqUserService hqUserService;

    @Autowired
    public HqUserController(HqUserService hqUserService) {
        this.hqUserService = hqUserService;
    }

    @GetMapping("/user")
    public List<AdminUserRegisterDto> getUsers(){
        try{
            List<AdminUserRegisterDto> users = hqUserService.findUsers()
                    .stream()
                    .map(
                            adminUser -> AdminUserRegisterDto.builder()
                                    .loginId(adminUser.getLoginId())
                                    .email(adminUser.getEmail())
                                    .loginPw(adminUser.getLoginPw())
                                    .lstDate(adminUser.getLstDate())
                                    .rgtDate(adminUser.getRgtDate())
                                    .name(adminUser.getName())
                                    .phoneNumber(adminUser.getPhone_number())
                                    .roles(adminUser.getRoles())
                                    .build()
                        )
                    .toList();
            return users;
        } catch (Exception e) {
            log.error("/users error occured");
            return null;
        }
    }

    @PostMapping("/adminWeb/register")
    public String saveUser(
            @RequestBody AdminUserRegisterDto requestBody
    ){
        try{
            hqUserService.join(requestBody);
            return "good";
        }catch (Exception e) {
            log.error("post /user error occured");
            return null;
        }
    }
}
