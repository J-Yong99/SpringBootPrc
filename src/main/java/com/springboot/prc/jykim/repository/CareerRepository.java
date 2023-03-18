package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}