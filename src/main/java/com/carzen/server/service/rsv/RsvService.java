package com.carzen.server.service.rsv;

import com.carzen.server.domain.Company;
import com.carzen.server.domain.CarInd;
import com.carzen.server.domain.Customer;
import com.carzen.server.domain.RsvInfo;

import java.util.List;
import java.util.Optional;

public interface RsvService {
    // 예약 내역 관리
    List<RsvInfo> getRsv(Optional<Long> id, Optional<CarInd> carInd, Optional<Customer> customer, Optional<Company> company, Optional<String> status);
    // id
}
