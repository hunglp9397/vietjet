package com.booking.vietjet.domain.flight.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;

    @Column(name="seat_code")
    private String seatCode;

    @Column(name="position")
    private String position;

    @Enumerated(EnumType.STRING)
    @Column(name = "class")
    private SeatClass seatClass;
}


