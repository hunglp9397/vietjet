package com.booking.vietjet.domain.booking.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "booking_direction")
@Data
public class BookingDirection {

    @Id
    @Column(nullable = false, name = "bd_id")
    private Long bookingDirectionId;

    @Column(nullable = false, name = "booking_id")
    private Long bookingId;

    @Column(nullable = false, name = "flight_id")
    private Long flightId;

    @Column(name = "direction")
    private int direction; // 0 OR 1

    @Column(name = "subtotal_amount")
    private Double subTotalAmount;

}
