package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.CompHoliday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompHolidayRepository extends JpaRepository<CompHoliday, Long> {
}