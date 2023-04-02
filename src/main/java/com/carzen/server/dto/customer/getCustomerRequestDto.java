package com.carzen.server.dto.customer;

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
    @Enumerated(EnumType.STRING)
    private CustomerRole role;
}
