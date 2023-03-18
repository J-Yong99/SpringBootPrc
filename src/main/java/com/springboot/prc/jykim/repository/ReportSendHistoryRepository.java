package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.ReportSendHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportSendHistoryRepository extends JpaRepository<ReportSendHistory, Long> {
}