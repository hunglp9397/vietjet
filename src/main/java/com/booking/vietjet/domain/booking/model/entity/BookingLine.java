package com.booking.vietjet.domain.booking.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "booking_line")
@Data
public class BookingLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bl_id", nullable = false)
    private Long bookingLineId;

    @Column(name = "bd_id")
    private Long bookingDirectionId;

    @Column(name = "type")
    private String type;

    @Column(name = "unit_amount")
    private String unitAmount;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "subtotal_amount")
    private Double subTotalAmount;

}
