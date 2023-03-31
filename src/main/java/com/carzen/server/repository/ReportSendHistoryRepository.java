package com.carzen.server.repository;

import com.carzen.server.domain.ReportSendHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportSendHistoryRepository extends JpaRepository<ReportSendHistory, Long> {
}