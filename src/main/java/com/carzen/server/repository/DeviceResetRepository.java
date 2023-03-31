package com.carzen.server.repository;

import com.carzen.server.domain.DeviceReset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceResetRepository extends JpaRepository<DeviceReset, Long> {
}