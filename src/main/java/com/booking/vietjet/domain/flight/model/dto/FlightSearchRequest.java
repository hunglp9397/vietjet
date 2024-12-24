package com.booking.vietjet.domain.flight.model.dto;





import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FlightSearchRequest implements Serializable {

    @JsonProperty("type")
    private Integer type;

    @JsonProperty("airline_id")
    private Integer airlineId;

    @JsonProperty("origin_airport_id")
    private Integer originAirportId;

    @JsonProperty("destination_airport_id")
    private Integer destinationAirportId;

    @JsonProperty("departure_time")
    private LocalDateTime departureTime;

    @JsonProperty("arrival_time")
    private LocalDateTime arrivalTime;

    @JsonProperty("min_price")
    private BigDecimal minPrice;

    @JsonProperty("max_price")
    private BigDecimal maxPrice;

    @JsonProperty("page")
    private Integer page = 0;

    @JsonProperty("page_size")
    private Integer pageSize = 10;



}
