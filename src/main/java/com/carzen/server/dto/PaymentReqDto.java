package com.carzen.server.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentReqDto {
    private String userName;

    private String phoneNumber;

    private String payType;

    private Long amount;

    private Long rsvId;

}
