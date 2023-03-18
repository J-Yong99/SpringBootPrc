package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.CustomerCenterManual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCenterManualRepository extends JpaRepository<CustomerCenterManual, Long> {
}