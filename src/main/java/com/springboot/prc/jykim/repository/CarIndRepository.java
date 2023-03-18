package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.CarInd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarIndRepository extends JpaRepository<CarInd, Long> {
}