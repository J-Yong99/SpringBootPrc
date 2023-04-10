package com.carzen.server.service;

import com.carzen.server.domain.CustomerCenterInquiries;
import com.carzen.server.repository.CustomerCenterInquiriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerCenterInquiriesService {
    @Autowired
    private CustomerCenterInquiriesRepository customerCenterInquiriesRepository;

    public List<CustomerCenterInquiries> searchInquiries(Long id, Long hqUserId, Long rsvInfoId, Long companyId, LocalDateTime announcedDateStart, LocalDateTime announcedDateEnd, String contents, String type, String customerName, String hqPart, String solution, String answerSolution, String phoneNumber) {
        if(id == null && hqUserId == null && rsvInfoId == null && companyId == null && announcedDateStart == null && announcedDateEnd == null && contents == null && type == null && customerName == null && hqPart == null && solution == null && answerSolution == null && phoneNumber == null) {
            return customerCenterInquiriesRepository.findAll();
        }
        return customerCenterInquiriesRepository.searchInquiries(id, hqUserId, rsvInfoId, companyId, announcedDateStart, announcedDateEnd, contents, type, customerName, hqPart, solution, answerSolution, phoneNumber);

    }

    public Page<CustomerCenterInquiries> searchInquiriesWithPaging(Pageable pageable, Long id, Long hqUserId, Long rsvInfoId, Long companyId, LocalDateTime announcedDateStart, LocalDateTime announcedDateEnd, String contents, String type, String customerName, String hqPart, String solution, String answerSolution, String phoneNumber) {
        return customerCenterInquiriesRepository.searchInquiriesWithPaging(pageable, id, hqUserId, rsvInfoId, companyId, announcedDateStart, announcedDateEnd, contents, type, customerName, hqPart, solution, answerSolution, phoneNumber);

    }
}
