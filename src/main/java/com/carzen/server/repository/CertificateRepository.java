package com.carzen.server.repository;

import com.carzen.server.domain.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}