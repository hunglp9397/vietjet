package com.booking.vietjet.domain.booking.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name="status")
    private String status;

    @Column(name="debit_acc")
    private String debitAcc;

    @Column(name="credit_acc")
    private String creditAcc;

    @Column(name="fee_charge")
    private String feeCharge;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="booking_id")
    private Long bookingId;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="txn_detail")
    private String transDetail;

    @Column(name="created_at")
    private LocalDateTime createdAt;

}
