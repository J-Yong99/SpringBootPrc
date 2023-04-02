package com.carzen.server.dto;

import com.carzen.server.domain.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDto {

    private Long id;

    private Long carIndId;

    private Long companyId;

    private Long customerId;

    private Long paymentInfoId;

    private String rsvStatus;

    private String insStatus;

    private LocalDate yearDate;

    private Long inspectTime;

    private String customerName;

    private String customerPhoneNumber;

    public static ReservationDto fromEntity(RsvInfo reservation) {
        ReservationDtoBuilder builder = ReservationDto.builder()
                .id(reservation.getId())
                .carIndId(reservation.getCarInd() != null ? reservation.getCarInd().getId() : null)
                .companyId(reservation.getCompany() != null ? reservation.getCompany().getId() : null)
                .customerId(reservation.getCustomer() != null ? reservation.getCustomer().getId() : null)
                .paymentInfoId(reservation.getPaymentInfo() != null ? reservation.getPaymentInfo().getId() : null)
                .rsvStatus(reservation.getRsvStatus())
                .insStatus(reservation.getInsStatus())
                .yearDate(reservation.getYearDate())
                .inspectTime(reservation.getInpectTime())
                .customerName(reservation.getCustomerName())
                .customerPhoneNumber(reservation.getCustomerPhoneNumber());

        return builder.build();
    }


    public RsvInfo toEntity() {
        return RsvInfo.builder()
                .id(id)
                .carInd(carIndId != null ? CarInd.builder().id(carIndId).build() : null)
                .company(companyId != null ? Company.builder().id(companyId).build() : null)
                .customer(customerId != null ? Customer.builder().id(customerId).build() : null)
                .paymentInfo(paymentInfoId != null ? PaymentInfo.builder().id(paymentInfoId).build() : null)
                .rsvStatus(rsvStatus)
                .insStatus(insStatus)
                .yearDate(yearDate)
                .inpectTime(inspectTime)
                .customerName(customerName)
                .customerPhoneNumber(customerPhoneNumber)
                .build();
    }
}
