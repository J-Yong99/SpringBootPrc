package com.carzen.server.controller;

import com.carzen.server.domain.HqUser;
import com.carzen.server.dto.HqUserRegisterDto;
import com.carzen.server.service.HqUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/hqUser")
    public List<HqUser> getUsers(){
        try{
            return hqUserService.findUsers();
        } catch (Exception e) {
            log.error("/users error occured");
            return null;
        }
    }

    @PostMapping("/hqUser")
    public ResponseEntity<?> saveUser(
            @RequestBody HqUserRegisterDto requestBody
    ){
        try{
            hqUserService.join(requestBody);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            log.error("post /hqUser error occured");
            return null;
        }
    }
}
