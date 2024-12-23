package com.booking.vietjet.domain.booking.service;


import com.booking.vietjet.app.common.ApiResponse;
import com.booking.vietjet.domain.booking.model.dto.BookingRequest;
import com.booking.vietjet.domain.booking.model.entity.Booking;
import com.booking.vietjet.domain.booking.repository.BookingRepository;
import com.booking.vietjet.domain.flight.model.entity.Flight;
import com.booking.vietjet.domain.flight.repository.FlightRepository;
import com.booking.vietjet.domain.flight.repository.TicketTypePriceRepository;
import com.booking.vietjet.domain.user.domain.entity.User;
import com.booking.vietjet.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private TicketTypePriceRepository ticketTypePriceRepository;

    @Autowired
    private UserRepository userRepository;


    public ApiResponse createBooking(BookingRequest request) {
        ApiResponse response = new ApiResponse();

        try {
            User user = userRepository.findById(Long.valueOf(request.getUserId())).orElseThrow(() -> new Exception("User not found"));
            Flight flight = flightRepository.findById(Long.valueOf(request.getFlightId())).orElseThrow(() -> new Exception("Flight not found"));

            Booking booking = Booking.builder()
                    .userId(Long.valueOf(request.getUserId()))
                    .flightId(Long.valueOf(request.getFlightId()))
                    .status(request.getStatus())
                    .subtotal(request.getSubtotal())
                    .discount(request.getDiscount())
//                    .totalAmount(totalAmount)
                    .bookingTime(LocalDateTime.now())
                    .note(request.getNote())
                    .build();

            // Lưu booking vào cơ sở dữ liệu
            booking = bookingRepository.save(booking);
            response.setData(booking);
            response.setMessage(new ApiResponse.Message(201, "Booking created successfully"));
        } catch (Exception e) {
            response.setData(null);
            response.setMessage(new ApiResponse.Message(500, "Failed while creating booking!" +  e.getMessage()));
        }
        return response;
    }

    public List<Booking> getBookingHistoryByUserId(Long userId) {

        return bookingRepository.findByUserId(userId);
    }
}







