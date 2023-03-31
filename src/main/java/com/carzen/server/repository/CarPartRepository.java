package com.carzen.server.repository;

import com.carzen.server.domain.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}