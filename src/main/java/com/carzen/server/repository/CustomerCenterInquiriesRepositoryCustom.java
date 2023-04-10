package com.carzen.server.repository;

import com.carzen.server.domain.CustomerCenterInquiries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerCenterInquiriesRepositoryCustom {
    List<CustomerCenterInquiries> searchInquiries(Long id, Long hqUserId, Long rsvInfoId, Long companyId, LocalDateTime announcedDateStart, LocalDateTime announcedDateEnd, String contents, String type, String customerName, String hqPart, String solution, String answerSolution, String phoneNumber);

    Page<CustomerCenterInquiries> searchInquiriesWithPaging(Pageable pageable, Long id, Long hqUserId, Long rsvInfoId, Long companyId, LocalDateTime announcedDateStart, LocalDateTime announcedDateEnd, String contents, String type, String customerName, String hqPart, String solution, String answerSolution, String phoneNumber);
}
