package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.CustomerCenterInquiries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCenterInquiriesRepository extends JpaRepository<CustomerCenterInquiries, Long> {
}