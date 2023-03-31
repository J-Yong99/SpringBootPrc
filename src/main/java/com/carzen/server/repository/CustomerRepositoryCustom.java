package com.carzen.server.repository;

import com.carzen.server.domain.CustomerRole;
import com.carzen.server.domain.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> searchCustomers(Long id, String serialNumber, String name, String phoneNumber, CustomerRole role);
}
