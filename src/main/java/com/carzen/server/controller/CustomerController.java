package com.carzen.server.controller;

import com.carzen.server.domain.Customer;
import com.carzen.server.domain.CustomerRole;
import com.carzen.server.dto.customer.CustomerRegisterDto;
import com.carzen.server.dto.customer.getCustomerRequestDto;
import com.carzen.server.repository.CustomerRepository;
import com.carzen.server.security.userdetails.CustomerUserDetails;
import com.carzen.server.service.CustomerService;
import com.carzen.server.utils.JwtTokenUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {
    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService, JwtTokenUtils jwtTokenUtils) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.jwtTokenUtils = jwtTokenUtils;
    }
    private CustomerRepository customerRepository;
    private CustomerService customerService;
    private JwtTokenUtils jwtTokenUtils;
    @GetMapping("/customer")
    public List<Customer> getUsers(){
        CustomerUserDetails customerDetails = (CustomerUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 접속자의 정보를 SecurityContextHolder에서 가져옴
        System.out.println("customerDetails.getPhoneNumber() = " + customerDetails.getPhoneNumber());
        return customerRepository.findAll();
    }

    @GetMapping("/customer/sort")
    public List<Customer> getCustomers(
            @RequestBody getCustomerRequestDto requestBody
    )throws Exception{
        return customerService.getCustomer(requestBody.getId(), requestBody.getSerialNumber(), requestBody.getRole());
    }

    @PostMapping("/customer1")
    public String saveUser(
            @RequestBody CustomerRegisterDto requestBody
    ){
        try{
            customerService.join(requestBody, CustomerRole.CUSTOMERA);
            return jwtTokenUtils.generateAccessToken(requestBody.getSerialNumber(), "customer");
        }catch (Exception e) {
            log.error("post /customer1 error occured");
            return null;
        }
    }

    @PostMapping("/customer2")
    public ResponseEntity<?> updateRole(
            @RequestBody CustomerRegisterDto requestBody
    ){
        try{
            customerService.join(requestBody, CustomerRole.CUSTOMERB);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            log.error("post /customer2 error occured");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error in register/customer2");
        }
    }
}
