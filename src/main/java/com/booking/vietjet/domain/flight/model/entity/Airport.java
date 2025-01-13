package com.booking.vietjet.domain.flight.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @Column(name = "airport_code")
    private String airportCode;

    @Column(name="name")
    private String name;

}
