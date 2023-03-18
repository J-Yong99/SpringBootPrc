package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}