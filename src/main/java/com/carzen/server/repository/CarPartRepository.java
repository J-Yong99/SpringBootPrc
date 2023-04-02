package com.carzen.server.repository;

import com.carzen.server.domain.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}