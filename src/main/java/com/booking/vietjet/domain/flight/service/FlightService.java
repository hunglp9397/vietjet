package com.booking.vietjet.domain.flight.service;

import com.booking.vietjet.app.common.ApiResponse;
import com.booking.vietjet.app.common.ApiResponseSearch;
import com.booking.vietjet.domain.flight.model.dto.FlightSearchRequest;
import com.booking.vietjet.domain.flight.model.entity.Flight;
import com.booking.vietjet.domain.flight.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public ApiResponseSearch searchFlights(FlightSearchRequest request) {
        ApiResponseSearch apiResponse = new ApiResponseSearch();
        try {
            List<Flight> flights = flightRepository.searchFlights(
                    request.getType(),
                    request.getAirlineId(),
                    request.getOriginAirportId(),
                    request.getDestinationAirportId(),
                    request.getDepartureTime(),
                    request.getArrivalTime(),
                    request.getMinPrice(),
                    request.getMaxPrice(),
                    request.getPageSize(),
                    request.getPage()
            );
            apiResponse.setData(flights);
            apiResponse.setLimit(request.getPageSize());
            apiResponse.setOffset(request.getPageSize());
            apiResponse.setTotalCount(flights.size());
        }catch (Exception e){
            apiResponse.setMessage(new ApiResponse.Message(500, e.getMessage()));
//            log.error(e.getMessage());
        }

        return apiResponse;

    }
}
