package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}