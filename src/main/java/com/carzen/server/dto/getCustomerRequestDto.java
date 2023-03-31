package com.carzen.server.dto;

import com.carzen.server.domain.CustomerRole;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class getCustomerRequestDto {
    private Long id;
    private String serialNumber;

    private String name;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private CustomerRole role;
}
