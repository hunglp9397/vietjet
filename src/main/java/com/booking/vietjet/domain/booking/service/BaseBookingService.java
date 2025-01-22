package com.booking.vietjet.domain.booking.service;

import com.booking.vietjet.domain.booking.model.dto.BookingRequest;
import com.booking.vietjet.domain.booking.model.dto.BookingResponse;
import com.booking.vietjet.domain.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseBookingService implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;



    @Override
    public BookingResponse execute(BookingRequest bookingRequest) {
        validateRequest(bookingRequest);
        checkAvailability(bookingRequest);

        // bookingRepository.save(bookingRequest);

        sendNotification(bookingRequest);

        return new BookingResponse();

    }

    protected void sendNotification(BookingRequest bookingRequest) {
    }

    protected void validateRequest(BookingRequest bookingRequest) {
    }

    protected void checkAvailability(BookingRequest bookingRequest) {
        
    }
}
