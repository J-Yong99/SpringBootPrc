package com.carzen.server.controller;


import com.carzen.server.domain.RsvInfo;
import com.carzen.server.dto.ReservationDto;

import com.carzen.server.service.RsvInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> reservationInfo = new HashMap<>();
        reservationInfo = rsvInfoService.createRsvInfo(requestBody);
//        new ReservationDto();
//        ReservationDto responseDto = ReservationDto.fromEntity(rsvInfo);
        return ResponseEntity.ok(reservationInfo);

    }

    //예약 내역 수정
    @PutMapping("/reservation/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        RsvInfo updatedReservation = rsvInfoService.updateReservation(id, reservationDto);
        return ResponseEntity.ok().body(ReservationDto.fromEntity(updatedReservation));
    }

    //예약 내역 조회
    @GetMapping("/reservation")
    public ResponseEntity<?> searchRsvWithPaging(Pageable pageable,
                                                 @RequestParam(required = false) Long id,
                                                 @RequestParam(required = false) Long carIndId,
                                                 @RequestParam(required = false) Long companyId,
                                                 @RequestParam(required = false) Long customerId,
                                                 @RequestParam(required = false) Long paymentInfoId,
                                                 @RequestParam(required = false) String rsvStatus,
                                                 @RequestParam(required = false) String insStatus,
                                                 @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate yearDateStart,
                                                 @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate yearDateEnd,
                                                 @RequestParam(required = false) Long inspectTime,
                                                 @RequestParam(required = false) String customerName,
                                                 @RequestParam(required = false) String customerPhoneNumber,
                                                 @RequestParam(required = false) String carName) {

        if(pageable.getPageNumber() == 0 && pageable.getPageSize() == 20){
            List<RsvInfo> rsvInfoList;
            rsvInfoList = rsvInfoService.searchRsv(id, carIndId, companyId, customerId, paymentInfoId, rsvStatus, insStatus, yearDateStart, yearDateEnd, inspectTime, customerName, customerPhoneNumber, carName);
            return ResponseEntity.ok(rsvInfoList);
        }
        else{
            int pageNum = pageable.getPageNumber();
            Page<RsvInfo> rsvInfoList = rsvInfoService.searchRsvWithPaging(PageRequest.of(pageNum - 1, pageable.getPageSize(), pageable.getSort()), id, carIndId, companyId, customerId, paymentInfoId, rsvStatus, insStatus, yearDateStart, yearDateEnd, inspectTime, customerName, customerPhoneNumber, carName);
            return ResponseEntity.ok(new PageImpl<>(rsvInfoList.getContent(), pageable, rsvInfoList.getTotalElements()));
        }

    }
}
