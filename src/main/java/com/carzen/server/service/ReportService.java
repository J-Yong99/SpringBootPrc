package com.carzen.server.service;

import com.carzen.server.domain.Report;
import com.carzen.server.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> searchReport(Long id, Long inspectPaperId, LocalDate expireDate, Long fixCount, String url, Long maxFixCount, Long reportNum, LocalDate inspectDateStart, LocalDate inspectDateEnd, String carNum, Long companyId, Long carTypeId, String carName, String phoneNumber) {
        if(id == null && inspectPaperId == null && expireDate == null && fixCount == null && url == null && maxFixCount == null && reportNum == null && inspectDateStart == null && inspectDateEnd == null && carNum == null && companyId == null && carTypeId == null && carName == null && phoneNumber == null) {
            return reportRepository.findAll();
        }
        return reportRepository.searchReport(id, inspectPaperId, expireDate, fixCount, url, maxFixCount, reportNum, inspectDateStart, inspectDateEnd, carNum, companyId, carTypeId, carName, phoneNumber);
    }

    public Page<Report> searchReportWithPaging(Pageable pageable, Long id, Long inspectPaperId, LocalDate expireDate, Long fixCount, String url, Long maxFixCount, Long reportNum, LocalDate inspectDateStart, LocalDate inspectDateEnd, String carNum, Long companyId, Long carTypeId, String carName, String phoneNumber) {
        return reportRepository.searchReportWithPaging(pageable, id, inspectPaperId, expireDate, fixCount, url, maxFixCount, reportNum, inspectDateStart, inspectDateEnd, carNum, companyId, carTypeId, carName, phoneNumber);
    }
}
