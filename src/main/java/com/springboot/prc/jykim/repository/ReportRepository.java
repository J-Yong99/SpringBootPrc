package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}