package com.booking.vietjet.app.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {


    @GetMapping()
    public String getListBookings() {
        return "1";
    }


}
