package com.booking.vietjet.domain.flight.repository;

import com.booking.vietjet.domain.flight.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT * FROM flight f " +
            "WHERE (:type IS NULL OR f.type = :type) " +
            "AND (:airlineId IS NULL OR f.airline_id = :airlineId) " +
            "AND (:originAirportId IS NULL OR f.origin_airport_id = :originAirportId) " +
            "AND (:destinationAirportId IS NULL OR f.destination_airport_id = :destinationAirportId) " +
            "AND (:minPrice IS NULL OR f.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR f.price <= :maxPrice) ",
//            "LIMIT :limit OFFSET :offset",
            nativeQuery = true)
    List<Flight> searchFlights(
            @Param("type") Integer type,
            @Param("airlineId") Integer airlineId,
            @Param("originAirportId") Integer originAirportId,
            @Param("destinationAirportId") Integer destinationAirportId,
            @Param("departureTime") LocalDateTime departureTime,
            @Param("arrivalTime") LocalDateTime arrivalTime,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("limit") Integer limit,
            @Param("offset") Integer offset);
}

