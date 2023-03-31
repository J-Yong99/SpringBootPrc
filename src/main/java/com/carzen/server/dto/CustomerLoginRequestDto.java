package com.carzen.server.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerLoginRequestDto {
    private String serialNumber;
}
