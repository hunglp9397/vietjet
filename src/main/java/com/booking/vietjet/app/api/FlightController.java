package com.booking.vietjet.app.api;


import com.booking.vietjet.app.common.ApiResponse;
import com.booking.vietjet.domain.flight.model.dto.FlightSearchRequest;
import com.booking.vietjet.domain.flight.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchFlights(
            @RequestBody FlightSearchRequest request) {
        ApiResponse<?> apiResponse = flightService.searchFlights(request);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
