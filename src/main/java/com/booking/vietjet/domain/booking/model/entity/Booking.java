package com.booking.vietjet.domain.booking.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "note")
    private String note;



}
