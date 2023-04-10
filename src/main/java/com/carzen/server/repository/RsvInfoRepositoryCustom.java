package com.carzen.server.repository;

import com.carzen.server.domain.RsvInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface RsvInfoRepositoryCustom {
    List<RsvInfo> searchRsv(Long id, Long carIndId, Long companyId, Long customerId, Long paymentInfoId, String rsvStatus, String insStatus, LocalDate yearDateStart, LocalDate yearDateEnd, Long inspectTime, String customerName, String customerPhoneNumber, String carName);

    Page<RsvInfo> searchRsvWithPaging(Pageable pageable, Long id, Long carIndId, Long companyId, Long customerId,
                                      Long paymentInfoId, String rsvStatus, String insStatus,
                                      LocalDate yearDateStart, LocalDate yearDateEnd, Long inspectTime, String customerName,
                                      String customerPhoneNumber, String carName);
}
