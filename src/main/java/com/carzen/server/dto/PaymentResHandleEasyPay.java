package com.carzen.server.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResHandleEasyPay {
    String provider;
    String amount;
    String discountAmount;
}
