package com.carzen.server.repository;

import com.carzen.server.domain.CancelPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CancelPolicyRepository extends JpaRepository<CancelPolicy, Long> {
}