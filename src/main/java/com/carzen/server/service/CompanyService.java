package com.carzen.server.service;

import com.carzen.server.domain.Company;
import com.carzen.server.domain.Device;
import com.carzen.server.dto.CompanyRegisterDto;
import com.carzen.server.repository.CompanyRepository;
import com.carzen.server.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public void join(CompanyRegisterDto request) throws Exception{
        Company company = Company.builder()
                .name(request.getName())
                .isContract(request.getIsContract())
                .phoneNumber(request.getPhoneNumber())
                .zipCode(request.getZipCode())
                .jiAddress(request.getJiAddress())
                .roadAddress(request.getRoadAddress())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .compRegNum(request.getCompRegNum())
                .shopImage(request.getShopImage())
                .profileImage(request.getProfileImage())
                .canForeignCar(request.getCanForeignCar())
                .bank(request.getBank())
                .accountNumber(request.getAccountNumber())
                .accountOwner(request.getAccountOwner())
                .build();
        Device device = deviceRepository.findById(request.getDeviceId()).orElseThrow(() -> new UsernameNotFoundException("Device not found"));
        device.setCompany(company);
        deviceRepository.save(device);
        companyRepository.save(company);
    }

    public List<Company> findCompanyAll(){
        return companyRepository.findAll();
    }
}
