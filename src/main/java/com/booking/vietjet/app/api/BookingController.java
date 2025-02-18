package com.booking.vietjet.app.api;

import com.booking.vietjet.domain.booking.model.dto.BookingRequest;
import com.booking.vietjet.domain.booking.service.BookingFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingFactory bookingFactory;


    @GetMapping()
    public String getListBookings() {
        return "1";
    }

    @PostMapping
    public void booking(@RequestBody BookingRequest bookingRequest) {
        bookingFactory.build(bookingRequest);
    }
}
