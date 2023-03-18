package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.DeviceReset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceResetRepository extends JpaRepository<DeviceReset, Long> {
}