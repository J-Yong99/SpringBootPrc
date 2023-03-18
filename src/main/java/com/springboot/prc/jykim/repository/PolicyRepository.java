package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}