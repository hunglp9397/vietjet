package com.booking.vietjet.domain.flight.repository;

import com.booking.vietjet.domain.flight.model.dto.FlightDto;
import com.booking.vietjet.domain.flight.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<FlightDto> findFlights();
}
