package com.carzen.server.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRegisterDto {
    private String serialNumber;

    private String name;

    private String phoneNumber;
}
