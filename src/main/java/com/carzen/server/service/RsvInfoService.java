package com.carzen.server.service;

import com.carzen.server.domain.CarInd;
import com.carzen.server.domain.Company;
import com.carzen.server.domain.Customer;
import com.carzen.server.domain.RsvInfo;
import com.carzen.server.dto.CompanyRegisterDto;
import com.carzen.server.dto.ReservationRegisterDto;
import com.carzen.server.repository.CarIndRepository;
import com.carzen.server.repository.CompanyRepository;
import com.carzen.server.repository.CustomerRepository;
import com.carzen.server.repository.RsvInfoRepository;
import com.carzen.server.security.userdetails.CustomerUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RsvInfoService {
    @Autowired
    private RsvInfoRepository rsvInfoRepository;
    @Autowired
    private CarIndRepository carIndRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    public Long createRsvInfo(ReservationRegisterDto requestBody) {
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
        return rsvInfo.getId();
    }
    // 예약 내역 관리
    // id
}
