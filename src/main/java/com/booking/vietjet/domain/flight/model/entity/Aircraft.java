package com.booking.vietjet.domain.flight.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AircraftStatus status;

}
