package com.carzen.server.dto.customer;

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
