package com.booking.vietjet.domain.booking.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "booking_passenger")
@Data
public class BookingPassenger {

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "passenger_id")
    private Long passengerId;
}
