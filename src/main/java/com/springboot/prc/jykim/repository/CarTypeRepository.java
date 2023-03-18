package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType, Long> {
}