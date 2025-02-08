package com.booking.vietjet.infrastructure.repository;


import com.booking.vietjet.domain.flight.model.entity.Airport;
import com.booking.vietjet.domain.flight.repository.AirportRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class AirportRepositoryImpl implements AirportRepository {

    @Override
    public List<Airport> findByCode(String code) {
        return Stream.of(
                new Airport("A200", "Airbus A200"),
                new Airport("A300", "Airbus A300"),
                new Airport("A400", "Airbus A400"),
                new Airport("A500", "Airbus A500")
        ).filter(item -> item.getAirportCode().equals(code)).collect(Collectors.toList());
    }
}
