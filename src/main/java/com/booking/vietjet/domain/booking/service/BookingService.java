package com.booking.vietjet.domain.booking.service;

import com.booking.vietjet.domain.booking.model.dto.BookingRequest;
import com.booking.vietjet.domain.booking.model.dto.BookingResponse;

public interface BookingService {
    BookingResponse execute(BookingRequest bookingRequest);
}
