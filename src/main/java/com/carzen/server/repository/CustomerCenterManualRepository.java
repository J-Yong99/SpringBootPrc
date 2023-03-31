package com.carzen.server.repository;

import com.carzen.server.domain.CustomerCenterManual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCenterManualRepository extends JpaRepository<CustomerCenterManual, Long> {
}