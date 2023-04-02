package com.carzen.server.repository;

import com.carzen.server.domain.CustomerCenterInquiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerCenterInquiriesRepository extends JpaRepository<CustomerCenterInquiries, Long> {
}