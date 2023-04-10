package com.carzen.server.repository;

import com.carzen.server.domain.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ReportRepositoryCustom {
    public List<Report> searchReport(Long id, Long inspectPaperId, LocalDate expireDate, Long fixCount, String url, Long maxFixCount, Long reportNum, LocalDate inspectDateStart, LocalDate inspectDateEnd, String carNum, Long companyId, Long carTypeId, String carName, String phoneNumber);
    public Page<Report> searchReportWithPaging(Pageable pageable, Long id, Long inspectPaperId, LocalDate expireDate, Long fixCount, String url, Long maxFixCount, Long reportNum, LocalDate inspectDateStart, LocalDate inspectDateEnd, String carNum, Long companyId, Long carTypeId, String carName, String phoneNumber);

}
