package com.carzen.server.security.userdetails;

import com.carzen.server.domain.Customer;
import com.carzen.server.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    public CustomerUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String serialNumber) throws UsernameNotFoundException {
        Customer customer = customerRepository.findBySerialNumber(serialNumber).orElseThrow(() -> new UsernameNotFoundException("CustomerUserDetailsService : can not find serial number : " + serialNumber));
        return new CustomerUserDetails(
                customer.getId(),
                customer.getName(),
                customer.getSerialNumber(),
                customer.getPhoneNumber(),
                customer.getRole()
        );
    }
}
