package com.booking.vietjet.domain.flight.service;

import com.booking.vietjet.domain.flight.model.dto.FlightDto;
import com.booking.vietjet.domain.flight.model.dto.FlightSearchReq;
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

    List<FlightDto> findFlights(FlightSearchReq flightSearchReq) {
        return flightRepository.findFlights();
    }
}
