package com.booking.vietjet.domain.flight.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class SeatAvailability {

    @Id
    private Long id;

    @Column(name="flight_id", nullable=false)
    private Long flightId;

    @Column(name="seat_code", nullable=false)
    private String seatCode;

    @Column(name="status")
    private String status;

    @Column(name="price")
    private BigDecimal price;

}
