package com.booking.vietjet.domain.flight.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long flightId;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;

    @Column(name="aircraft_code")
    private String aircraftCode;

    @Column(name="departure_airport")
    private String departureAirport;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;
}
