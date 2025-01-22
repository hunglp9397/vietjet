package com.booking.vietjet.domain.booking.service;

import com.booking.vietjet.domain.booking.model.dto.BookingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OneWayBookingService extends BaseBookingService{

    @Override
    protected void sendNotification(BookingRequest bookingRequest) {
        log.info("Sending notification for one way booking: {}", bookingRequest);
        super.sendNotification(bookingRequest);
    }

    @Override
    protected void validateRequest(BookingRequest bookingRequest) {
        log.info("Validating request for one way booking: {}", bookingRequest);
        super.validateRequest(bookingRequest);
    }

    @Override
    protected void checkAvailability(BookingRequest bookingRequest) {
        log.info("Checking availability for one way booking: {}", bookingRequest);
        super.checkAvailability(bookingRequest);
    }
}
