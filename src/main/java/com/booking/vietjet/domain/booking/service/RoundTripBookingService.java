package com.booking.vietjet.domain.booking.service;


import com.booking.vietjet.domain.booking.model.dto.BookingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoundTripBookingService extends BaseBookingService {


    @Override
    protected void sendNotification(BookingRequest bookingRequest) {
        log.info("Sending notification for roundtrip booking: {}", bookingRequest);
        super.sendNotification(bookingRequest);
    }

    @Override
    protected void validateRequest(BookingRequest bookingRequest) {
        log.info("Validating request for roundtrip booking: {}", bookingRequest);
        super.validateRequest(bookingRequest);
    }

    @Override
    protected void checkAvailability(BookingRequest bookingRequest) {
        log.info("Checking availability for roundtrip booking: {}", bookingRequest);
        super.checkAvailability(bookingRequest);
    }
}
