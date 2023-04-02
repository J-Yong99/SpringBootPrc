package com.carzen.server.repository;

import com.carzen.server.domain.CustomerRole;
import com.carzen.server.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepositoryCustom {
    List<Customer> searchCustomers(Long id, String serialNumber, CustomerRole role);
}
