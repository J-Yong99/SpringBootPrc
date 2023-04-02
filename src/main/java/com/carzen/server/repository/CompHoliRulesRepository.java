package com.carzen.server.repository;

import com.carzen.server.domain.CompanyHoliRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompHoliRulesRepository extends JpaRepository<CompanyHoliRules, Long> {
}