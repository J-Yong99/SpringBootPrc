package com.carzen.server.repository;

import com.carzen.server.domain.RegistrationTax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationTaxRepository extends JpaRepository<RegistrationTax, Long> {
}