package com.carzen.server.service;

import com.carzen.server.domain.CustomerRole;
import com.carzen.server.domain.Customer;
import com.carzen.server.dto.customer.CustomerRegisterDto;
import com.carzen.server.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    private CustomerRepository customerRepository;

    @Transactional
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

    public List<Customer> getCustomer(Long id, String serialNumber, CustomerRole role) {
        if (serialNumber == null && role == null) {
            return customerRepository.findAll();
        } else {
            return customerRepository.searchCustomers(id, serialNumber, role);
        }
    }
//    public List<Customer> searchCustomers(String name, String phoneNumber, CustomerRole role) {
//        ArrayBuilders.BooleanBuilder builder = new ArrayBuilders.BooleanBuilder();
//        if (name != null) {
//            builder.and(QCustomer.customer.name.contains(name));
//        }
//        if (phoneNumber != null) {
//            builder.and(QCustomer.customer.phoneNumber.contains(phoneNumber));
//        }
//        if (role != null) {
//            builder.and(QCustomer.customer.role.eq(role));
//        }
//        return (List<Customer>) customerRepository.findAll(builder.getValue());
//    }
}
