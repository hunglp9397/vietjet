package com.booking.vietjet.domain.booking.service;

import com.booking.vietjet.domain.booking.model.dto.BookingRequest;
import com.booking.vietjet.domain.booking.model.entity.BookingType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingFactory {

    private BaseBookingService baseBookingService;
    private OneWayBookingService oneWayBookingService;
    private RoundTripBookingService roundTripBookingService;


    public BookingService build(BookingRequest bookingRequest) {
        return switch (BookingType.of(bookingRequest.getType())) {
            case ONEWAY -> oneWayBookingService;
            case ROUNDTRIP -> roundTripBookingService;
            default -> baseBookingService;
        };
    }

}
