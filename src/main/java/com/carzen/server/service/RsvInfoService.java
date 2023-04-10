package com.carzen.server.service;

import com.carzen.server.domain.*;
import com.carzen.server.dto.ReservationDto;

import com.carzen.server.repository.*;
import com.carzen.server.security.userdetails.CustomerUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RsvInfoService {
    @Autowired
    private RsvInfoRepository rsvInfoRepository;
    @Autowired
    private CarIndRepository carIndRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private InspectCostRepository inspectCostRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    //예약 내역과 결제 내역을 생성해서 반환
    @Transactional
    public Map<String, Object> createRsvInfo(ReservationDto requestBody) {
        // 초기 예약 내역 생성
        // 예약 날짜가 이미 지난 값이거나 점검시간이 7을 넘어간 값인지 확인
        if(requestBody.getYearDate().isBefore(LocalDate.now())) throw new IllegalArgumentException("예약 날짜가 이미 지났습니다.");
        if(requestBody.getInspectTime() > 7) throw new IllegalArgumentException("점검 시간은 7을 넘을 수 없습니다.");
        CarInd carInd = carIndRepository.findById(requestBody.getCarIndId()).orElseThrow(() -> new IllegalArgumentException("차량 정보가 존재하지 않습니다."));
        Company company = companyRepository.findById(requestBody.getCompanyId()).orElseThrow(() -> new IllegalArgumentException("점검점 정보가 존재하지 않습니다."));
        CustomerUserDetails customerUserDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CustomerUserDetails ? (CustomerUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : null;
        if(customerUserDetails == null) throw new IllegalArgumentException("RsvInfoService.createInfo : 고객 정보가 존재하지 않습니다.");
        // 이미 해당 점검점,날짜,시간에 예약이 있는지 확인 필요
        if(rsvInfoRepository.existsByCompanyAndYearDateAndInspectTime(company, requestBody.getYearDate(), requestBody.getInspectTime())) throw new IllegalArgumentException("이미 예약된 시간입니다.");
        RsvInfo rsvInfo = RsvInfo.builder()
                .carInd(carInd)
                .company(company)
                .customer(new Customer(
                        customerUserDetails.getId()
                        , customerUserDetails.getSerialNumber()
                        , customerUserDetails.getRole()
                    )
                )
                .yearDate(requestBody.getYearDate())
                .inspectTime(requestBody.getInspectTime())
                .customerName(requestBody.getCustomerName())
                .customerPhoneNumber(requestBody.getCustomerPhoneNumber())
                .rsvStatus("예약대기")
                .insStatus("점검전")
                .build()
                ;
        // 결제정보도 생성
        // 점검료 찾기
        InspectCost inspectCost = inspectCostRepository.findByCarType(carInd.getCar().getCarType());
        PaymentInfo paymentInfo = PaymentInfo.builder()
                .rsvInfo(rsvInfo)
                .orderId(UUID.randomUUID().toString())
                .cost(inspectCost.getSaleCost())
                .status("결제대기")
                .build();
        // transaction으로 처리
        rsvInfoRepository.save(rsvInfo);
        paymentInfoRepository.save(paymentInfo);
        // Map 객체에 RsvInfo와 PaymentInfo를 담아서 반환
        Map<String, Object> result = new HashMap<>();
        result.put("rsvInfo", rsvInfo);
        result.put("paymentInfo", paymentInfo);
        return result;
    }


    public List<RsvInfo> searchRsv(Long id, Long carIndId, Long companyId, Long customerId, Long paymentInfoId, String rsvStatus, String insStatus, LocalDate yearDateStart, LocalDate yearDateEnd, Long inspectTime, String customerName, String customerPhoneNumber, String carName) {
        if(id == null && carIndId == null && companyId == null && customerId == null && paymentInfoId == null && rsvStatus == null && insStatus == null && yearDateStart == null && yearDateEnd == null && inspectTime == null && customerName == null && customerPhoneNumber == null && carName == null) {
            return rsvInfoRepository.findAll();
        }
        return rsvInfoRepository.searchRsv(id, carIndId, companyId, customerId, paymentInfoId, rsvStatus, insStatus, yearDateStart, yearDateEnd, inspectTime, customerName, customerPhoneNumber, carName);
    }

    public Page<RsvInfo> searchRsvWithPaging(Pageable pageable, Long id, Long carIndId, Long companyId, Long customerId,
                                             Long paymentInfoId, String rsvStatus, String insStatus,
                                             LocalDate yearDateStart, LocalDate yearDateEnd, Long inspectTime, String customerName,
                                             String customerPhoneNumber, String carName) {

        return rsvInfoRepository.searchRsvWithPaging(pageable, id, carIndId, companyId, customerId, paymentInfoId, rsvStatus, insStatus, yearDateStart, yearDateEnd, inspectTime, customerName, customerPhoneNumber, carName);
    }

    @Transactional
    public RsvInfo updateReservation(Long id, ReservationDto reservationDto) {
        RsvInfo rsvInfo = rsvInfoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid reservation id"));

        if (reservationDto.getCarIndId() != null) {
            rsvInfo.setCarInd(CarInd.builder().id(reservationDto.getCarIndId()).build());
        }

        if (reservationDto.getCompanyId() != null) {
            rsvInfo.setCompany(Company.builder().id(reservationDto.getCompanyId()).build());
        }

        if (reservationDto.getCustomerId() != null) {
            rsvInfo.setCustomer(Customer.builder().id(reservationDto.getCustomerId()).build());
        }

        if (reservationDto.getRsvStatus() != null) {
            rsvInfo.setRsvStatus(reservationDto.getRsvStatus());
        }

        if (reservationDto.getInsStatus() != null) {
            rsvInfo.setInsStatus(reservationDto.getInsStatus());
        }

        if (reservationDto.getYearDate() != null) {
            rsvInfo.setYearDate(reservationDto.getYearDate());
        }

        if (reservationDto.getInspectTime() != null) {
            rsvInfo.setInspectTime(reservationDto.getInspectTime());
        }

        if (reservationDto.getCustomerName() != null) {
            rsvInfo.setCustomerName(reservationDto.getCustomerName());
        }

        if (reservationDto.getCustomerPhoneNumber() != null) {
            rsvInfo.setCustomerPhoneNumber(reservationDto.getCustomerPhoneNumber());
        }

//        rsvInfoRepository.save(rsvInfo);
        return rsvInfo;
    }
}
