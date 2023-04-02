package com.carzen.server.controller;


import com.carzen.server.domain.RsvInfo;
import com.carzen.server.dto.ReservationDto;
import com.carzen.server.dto.ReservationRegisterDto;
import com.carzen.server.dto.ReservationRegisterResponseDto;
import com.carzen.server.security.userdetails.CompanyUserDetails;
import com.carzen.server.service.RsvInfoService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
            @RequestBody ReservationDto requestBody
    ) {
        RsvInfo rsvInfo = rsvInfoService.createRsvInfo(requestBody);
        new ReservationDto();
        ReservationDto responseDto = ReservationDto.fromEntity(rsvInfo);
        return ResponseEntity.ok(responseDto);

    }

    //예약 내역 수정
    @PutMapping("/reservation/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        RsvInfo updatedReservation = rsvInfoService.updateReservation(id, reservationDto);
        return ResponseEntity.ok().body(ReservationDto.fromEntity(updatedReservation));
    }

    //예약 내역 조회
    @GetMapping("/reservation")
    public ResponseEntity<?> searchRsvWithPagination(Pageable pageable,
                                                                    @RequestParam(required = false) Long id,
                                                                    @RequestParam(required = false) Long carIndId,
                                                                    @RequestParam(required = false) Long companyId,
                                                                    @RequestParam(required = false) Long customerId,
                                                                    @RequestParam(required = false) Long paymentInfoId,
                                                                    @RequestParam(required = false) String rsvStatus,
                                                                    @RequestParam(required = false) String insStatus,
                                                                    @RequestParam(required = false) LocalDate yearDate,
                                                                    @RequestParam(required = false) Long inspectTime,
                                                                    @RequestParam(required = false) String customerName,
                                                                    @RequestParam(required = false) String customerPhoneNumber) {

        if(pageable.getPageNumber() == 0 && pageable.getPageSize() == 20){
            List<RsvInfo> rsvInfoList;
            rsvInfoList = rsvInfoService.searchRsv(id, carIndId, companyId, customerId, paymentInfoId, rsvStatus, insStatus, yearDate, inspectTime, customerName, customerPhoneNumber);
            return ResponseEntity.ok(rsvInfoList);
        }
        else{
            int pageNum = pageable.getPageNumber();
            Page<RsvInfo> rsvInfoList = rsvInfoService.searchRsvWithPagination(PageRequest.of(pageNum - 1, pageable.getPageSize(), pageable.getSort()), id, carIndId, companyId, customerId, paymentInfoId, rsvStatus, insStatus, yearDate, inspectTime, customerName, customerPhoneNumber);
            return ResponseEntity.ok(new PageImpl<>(rsvInfoList.getContent(), pageable, rsvInfoList.getTotalElements()));
        }

    }
}
