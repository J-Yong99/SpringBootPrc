package com.carzen.server.security.userdetails;

import com.carzen.server.domain.Company;
import com.carzen.server.domain.Device;
import com.carzen.server.repository.CompanyRepository;
import com.carzen.server.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompanyUserDetailsService implements UserDetailsService {
    @Autowired
    public CompanyUserDetailsService(CompanyRepository companyRepository, DeviceRepository deviceRepository) {
        this.companyRepository = companyRepository;
        this.deviceRepository = deviceRepository;
    }

    private final CompanyRepository companyRepository;
    private final DeviceRepository deviceRepository;


    @Override
    public UserDetails loadUserByUsername(String serialNumber) throws UsernameNotFoundException {
        Device device = deviceRepository.findBySerialNumber(serialNumber).orElseThrow(() -> new UsernameNotFoundException("CompanyUserDetailsService : can not find device by serial number : " + serialNumber));
        Company company = device.getCompany();
        return new CompanyUserDetails(
                company.getId(),
                company.getName(),
                company.getIsContract(),
                company.getPhoneNumber(),
                company.getZipCode(),
                company.getJiAddress(),
                company.getRoadAddress(),
                company.getLatitude(),
                company.getLongitude(),
                company.getCompRegNum(),
                company.getShopImage(),
                company.getProfileImage(),
                company.getCanForeignCar(),
                company.getBank(),
                company.getAccountNumber(),
                company.getAccountOwner()
        );
    }
}
