package com.booking.vietjet.domain.booking.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "ticket_amount", nullable = false)
    private BigDecimal ticketAmount;

    @Column(name = "fee_amount", nullable = false)
    private BigDecimal feeAmount;

    @Column(name = "discount_count", nullable = false)
    private BigDecimal discountCount;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "checkout_at")
    private LocalDateTime checkoutAt;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @Column(name = "extra_data", columnDefinition = "json")
    private String extraData;

    @Column(nullable = false)
    private int version;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

}
