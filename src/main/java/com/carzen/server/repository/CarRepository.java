package com.carzen.server.repository;

import com.carzen.server.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CarRepository extends JpaRepository<Car, Long> {
}