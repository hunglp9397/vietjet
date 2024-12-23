package com.booking.vietjet.domain.flight.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ticket_type_price")
public class TicketTypePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "flight_id", nullable = false)
    private Long flightId;

    @Column(name = "classes_id", nullable = false)
    private Long classesId; // Hạng


    @Column(name = "ticket_type", nullable = false)
    private String ticketType; // Loại hành khách (Adult, Child, Infant)


    @Column(name = "price", nullable = false)
    private BigDecimal price;

}
