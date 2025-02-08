package com.booking.vietjet.domain.flight.repository;

import com.booking.vietjet.domain.flight.model.entity.Airport;

import java.util.List;

public interface AirportRepository {
    List<Airport> findByCode(String code);
}
