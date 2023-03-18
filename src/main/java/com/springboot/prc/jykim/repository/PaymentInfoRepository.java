package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
}