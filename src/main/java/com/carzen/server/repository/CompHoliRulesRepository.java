package com.carzen.server.repository;

import com.carzen.server.domain.CompanyHoliRules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompHoliRulesRepository extends JpaRepository<CompanyHoliRules, Long> {
}