package com.carzen.server.controller;

import com.carzen.server.service.CustomerCenterInquiriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerCenterInquiriesController {

    @Autowired
    private CustomerCenterInquiriesService customerCenterInquiriesService;
}
