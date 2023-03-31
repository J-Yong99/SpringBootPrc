package com.carzen.server.repository;

import com.carzen.server.domain.DeviceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceHistoryRepository extends JpaRepository<DeviceHistory, Long> {
}