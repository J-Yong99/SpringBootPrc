package com.carzen.server.repository;

import com.carzen.server.domain.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CarTypeRepository extends JpaRepository<CarType, Long> {
}