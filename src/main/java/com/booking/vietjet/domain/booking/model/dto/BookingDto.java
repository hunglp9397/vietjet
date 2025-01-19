package com.booking.vietjet.domain.booking.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class BookingDto {

    private Long id;

    private String status;

    private String voucherCode;

    private BigDecimal ticketAmount;

    private BigDecimal feeAmount;

    private BigDecimal discountCount;

    private BigDecimal totalAmount;

    private LocalDateTime checkoutAt;

    private LocalDateTime paidAt;

    private String extraData;

    private int version;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

}