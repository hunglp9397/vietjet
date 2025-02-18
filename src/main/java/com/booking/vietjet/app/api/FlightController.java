package com.booking.vietjet.app.api;



import com.booking.vietjet.app.common.ApiResponse;
import com.booking.vietjet.app.common.ApiResponseSearch;
import com.booking.vietjet.domain.flight.model.dto.FlightDto;
import com.booking.vietjet.domain.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping()
    public ApiResponseSearch searchFlights(@RequestBody FlightDto flightDto) {
        return airportService.getByCode(code);
    }


}
