package com.booking.vietjet.app.api;


import com.booking.vietjet.app.common.ApiResponse;
import com.booking.vietjet.domain.flight.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airport")
@AllArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/{code}")
    public ApiResponse getAirportByCode(@PathVariable("code") String code) {
        return airportService.getByCode(code);
    }
}
