package com.carzen.server.dto.customer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerLoginRequestDto {
    private String serialNumber;
}
