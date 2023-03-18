package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}