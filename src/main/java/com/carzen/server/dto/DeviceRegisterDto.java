package com.carzen.server.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceRegisterDto {
    private String serialNumber;

    private String status;

    private String certificateCode;

    private String description;
}
