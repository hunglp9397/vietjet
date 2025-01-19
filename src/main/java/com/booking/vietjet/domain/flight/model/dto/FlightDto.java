package com.booking.vietjet.domain.flight.model.dto;

import java.time.LocalDateTime;

public class FlightDto {

    private Long flightId;

    private String status;

    private String type;

    private String aircraftCode;

    private String departureAirport;

    private String arrivalAirport;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;
}
