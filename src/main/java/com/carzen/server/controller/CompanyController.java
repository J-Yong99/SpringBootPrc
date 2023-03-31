package com.carzen.server.controller;

import com.carzen.server.domain.Company;
import com.carzen.server.domain.CustomerRole;
import com.carzen.server.dto.CompanyRegisterDto;
import com.carzen.server.dto.CustomerRegisterDto;
import com.carzen.server.repository.CompanyRepository;
import com.carzen.server.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<String> registerCompany(
            @RequestBody CompanyRegisterDto requestBody
    ){
        try{
            companyService.join(requestBody);
            return ResponseEntity.ok("success");
        }catch (Exception e) {
            log.error("post /register/customer1 error occured");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error in /company");
        }
    }

    @GetMapping("/company")
    public ResponseEntity<?> getCompanies(){
        return ResponseEntity.ok(companyService.findCompanyAll());
    }

}
