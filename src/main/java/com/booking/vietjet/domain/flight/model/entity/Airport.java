package com.booking.vietjet.domain.flight.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "airport")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Airport implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "airport_code")
    private String airportCode;

    @Column(name="name")
    private String name;

}
