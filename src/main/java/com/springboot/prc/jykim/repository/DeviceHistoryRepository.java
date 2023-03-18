package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.DeviceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceHistoryRepository extends JpaRepository<DeviceHistory, Long> {
}