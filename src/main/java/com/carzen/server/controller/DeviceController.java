package com.carzen.server.controller;

import com.carzen.server.dto.DeviceRegisterDto;
import com.carzen.server.repository.DeviceRepository;
import com.carzen.server.service.DeviceService;
import com.carzen.server.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DeviceController {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @PostMapping("/device")
    public String registerDevice(
            @RequestBody DeviceRegisterDto requestBody
    ){
        try{
            deviceService.join(requestBody);
            return jwtTokenUtils.generateAccessToken(requestBody.getSerialNumber(), "company");
        } catch (Exception e) {
            log.error("post /device error occured");
            return null;
        }
    }
    // 모든 device 검색
    @GetMapping("/device")
    public ResponseEntity<?> getDevices(){
        return ResponseEntity.ok(deviceRepository.findAll());
    }

}
