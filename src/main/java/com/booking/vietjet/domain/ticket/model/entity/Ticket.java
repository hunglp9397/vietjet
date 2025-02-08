package com.booking.vietjet.domain.ticket.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(nullable = false, name = "flight_id")
    private Long flightId;

    @Column(nullable = false, name = "passenger_id")
    private Long passengerId;

    @Column(name = "seat_code")
    private String seatCode;

    @Column(name = "issued_at")
    private LocalDateTime issuedAt;

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "bd_id")
    private Long bookingDirectionId;

}
