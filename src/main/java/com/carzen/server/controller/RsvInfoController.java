package com.carzen.server.controller;


import com.carzen.server.dto.ReservationRegisterDto;
import com.carzen.server.dto.ReservationRegisterResponseDto;
import com.carzen.server.security.userdetails.CompanyUserDetails;
import com.carzen.server.service.RsvInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RsvInfoController {
    @Autowired
    public RsvInfoController(RsvInfoService rsvInfoService) {
        this.rsvInfoService = rsvInfoService;
    }
    private final RsvInfoService rsvInfoService;

    // 예약 내역 생성
    @PostMapping("/reservation")
    public ResponseEntity<?> createRsvInfo(
            @RequestBody ReservationRegisterDto requestBody
    ) {
//        Long id = rsvInfoService.createRsvInfo(requestBody);
        ReservationRegisterResponseDto responseDto = new ReservationRegisterResponseDto(
                1234L,
                1234L,
                1234L,
                "2021-01-01",
                3L,
                "홍길동",
                "010-1234-5678"
        );
        return ResponseEntity.ok(responseDto);

    }

}
