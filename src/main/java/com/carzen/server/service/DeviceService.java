package com.carzen.server.service;

import com.carzen.server.domain.Customer;
import com.carzen.server.domain.Device;
import com.carzen.server.dto.DeviceRegisterDto;
import com.carzen.server.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public void join(DeviceRegisterDto request)throws Exception{
        Optional<Device> optionalDevice = deviceRepository.findBySerialNumber(request.getSerialNumber());
        Device device;
        if(optionalDevice.isEmpty()){
            device = Device.builder()
                    .serialNumber(request.getSerialNumber())
                    .certificateCode(request.getCertificateCode())
                    .description(request.getDescription())
                    .status(request.getStatus())
                    .build();
        }else{
            throw new Exception("DeviceService : device already exist");
        }
        deviceRepository.save(device);
    }
}
