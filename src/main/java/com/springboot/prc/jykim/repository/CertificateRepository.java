package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}