package com.booking.vietjet.domain.flight.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flight")
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // 0 : một chiều
    // 1 : hai chiều
    @Column(name = "type", nullable = false)
    private int type;

    @Column(name = "airline_id", nullable = false)
    private int airlineId;

    @Column(name = "origin_airport_id", nullable = false)
    private int originAirportId;

    @Column(name = "destination_airport_id", nullable = false)
    private int destinationAirportId;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "seat_count", nullable = false)
    private int seatCount;

    @Column(name = "price")
    private BigDecimal price; // Sum of TicketTypePrice by flightID


}
