package com.booking.vietjet.app.api;

import com.booking.vietjet.app.common.ApiResponse;
import com.booking.vietjet.domain.booking.model.dto.BookingRequest;
import com.booking.vietjet.domain.booking.model.entity.Booking;
import com.booking.vietjet.domain.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    // Book a flight
    @PostMapping()
    public ResponseEntity<?> bookFlight(@RequestBody BookingRequest bookingRequest) {
        ApiResponse<?> apiResponse = bookingService.createBooking(bookingRequest);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    // Get history of booking
    @GetMapping("/history")
    public ResponseEntity<List<Booking>> getBookingHistory(@RequestParam Long userId) {
        List<Booking> bookingHistory = bookingService.getBookingHistoryByUserId(userId);
        return new ResponseEntity<>(bookingHistory, HttpStatus.OK);
    }


}
