package com.carzen.server.service;

import com.carzen.server.domain.*;
import com.carzen.server.dto.CompanyRegisterDto;
import com.carzen.server.dto.ReservationDto;

import com.carzen.server.repository.CarIndRepository;
import com.carzen.server.repository.CompanyRepository;
import com.carzen.server.repository.CustomerRepository;
import com.carzen.server.repository.RsvInfoRepository;
import com.carzen.server.security.userdetails.CustomerUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RsvInfoService {
    @Autowired
    private RsvInfoRepository rsvInfoRepository;
    @Autowired
    private CarIndRepository carIndRepository;
    @Autowired
    private CompanyRepository companyRepository;


    public RsvInfo createRsvInfo(ReservationDto requestBody) {
        // 초기 예약 내역 생성
        CarInd carInd = carIndRepository.findById(requestBody.getCarIndId()).orElseThrow(() -> new IllegalArgumentException("차량 정보가 존재하지 않습니다."));
        Company company = companyRepository.findById(requestBody.getCompanyId()).orElseThrow(() -> new IllegalArgumentException("점검점 정보가 존재하지 않습니다."));
        CustomerUserDetails customerUserDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CustomerUserDetails ? (CustomerUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : null;
        if(customerUserDetails == null) throw new IllegalArgumentException("RsvInfoService.createInfo : 로그인 정보가 존재하지 않습니다.");
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
                .inpectTime(requestBody.getInspectTime())
                .customerName(requestBody.getCustomerName())
                .customerPhoneNumber(requestBody.getCustomerPhoneNumber())
                .rsvStatus("예약대기")
                .insStatus("점검전")
                .build()
                ;
        rsvInfoRepository.save(rsvInfo);
        return rsvInfo;
    }

    public List<RsvInfo> searchRsv(Long id, Long carIndId, Long companyId, Long customerId, Long paymentInfoId, String rsvStatus, String insStatus, LocalDate yearDate, Long inspectTime, String customerName, String customerPhoneNumber) {
        if(id == null && carIndId == null && companyId == null && customerId == null && paymentInfoId == null && rsvStatus == null && insStatus == null && yearDate == null && inspectTime == null && customerName == null && customerPhoneNumber == null) {
            return rsvInfoRepository.findAll();
        }
        return rsvInfoRepository.searchRsv(id, carIndId, companyId, customerId, paymentInfoId, rsvStatus, insStatus, yearDate, inspectTime, customerName, customerPhoneNumber);
    }

    public Page<RsvInfo> searchRsvWithPagination(Pageable pageable, Long id, Long carIndId, Long companyId, Long customerId,
                                                 Long paymentInfoId, String rsvStatus, String insStatus,
                                                 LocalDate yearDate, Long inspectTime, String customerName,
                                                 String customerPhoneNumber) {

        return rsvInfoRepository.searchRsvWithPaging(pageable, id, carIndId, companyId, customerId, paymentInfoId, rsvStatus, insStatus, yearDate, inspectTime, customerName, customerPhoneNumber);
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

        if (reservationDto.getPaymentInfoId() != null) {
            rsvInfo.setPaymentInfo(PaymentInfo.builder().id(reservationDto.getPaymentInfoId()).build());
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
            rsvInfo.setInpectTime(reservationDto.getInspectTime());
        }

        if (reservationDto.getCustomerName() != null) {
            rsvInfo.setCustomerName(reservationDto.getCustomerName());
        }

        if (reservationDto.getCustomerPhoneNumber() != null) {
            rsvInfo.setCustomerPhoneNumber(reservationDto.getCustomerPhoneNumber());
        }

        rsvInfoRepository.save(rsvInfo);
        return rsvInfo;
    }
}
