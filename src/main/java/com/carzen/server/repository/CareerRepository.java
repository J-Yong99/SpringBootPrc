package com.carzen.server.repository;

import com.carzen.server.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CareerRepository extends JpaRepository<Career, Long> {
}