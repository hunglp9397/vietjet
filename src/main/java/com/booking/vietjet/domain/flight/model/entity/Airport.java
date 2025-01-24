package com.booking.vietjet.domain.flight.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "airport")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Airport {

    @Id
    @Column(name = "airport_code")
    private String airportCode;

    @Column(name="name")
    private String name;

}
