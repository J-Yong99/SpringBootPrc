package com.carzen.server.repository;

import com.carzen.server.domain.CompanyHoliday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompHolidayRepository extends JpaRepository<CompanyHoliday, Long> {
}