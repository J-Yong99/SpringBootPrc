package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}