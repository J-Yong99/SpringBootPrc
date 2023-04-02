package com.carzen.server.repository;

import com.carzen.server.domain.CarInd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CarIndRepository extends JpaRepository<CarInd, Long> {
}