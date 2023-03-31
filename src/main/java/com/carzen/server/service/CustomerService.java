package com.carzen.server.service;

import com.carzen.server.domain.CustomerRole;
import com.carzen.server.domain.Customer;
import com.carzen.server.dto.CustomerRegisterDto;
import com.carzen.server.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    private final CustomerRepository customerRepository;

    public void join(CustomerRegisterDto request, CustomerRole role) throws Exception{
        Optional<Customer> optionalCustomer = customerRepository.findBySerialNumber(request.getSerialNumber());
        Customer customer;
        if(optionalCustomer.isEmpty()){
                 customer = Customer.builder()
                .role(role)
                .serialNumber(request.getSerialNumber())
                .build();
        }else{
            customer = optionalCustomer.get();
            customer.setRole(role);
        }
        customerRepository.save(customer);
    }

//    public List<Customer> getCustomer(Long id, String serialNumber, String name, String phoneNumber, CustomerRole role) {
//        if (serialNumber == null && name == null && phoneNumber == null && role == null) {
//            return customerRepository.findAll();
//        } else {
//            return customerRepository.searchCustomers(id, serialNumber, name, phoneNumber, role);
//        }
//    }

}
