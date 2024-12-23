package com.booking.vietjet.domain.flight.model.dto;



//import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//@Data
public class FlightSearchRequest {
    private Integer type;
    private Integer airlineId;
    private Integer originAirportId;
    private Integer destinationAirportId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer page = 0;
    private Integer pageSize = 10;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public Integer getOriginAirportId() {
        return originAirportId;
    }

    public void setOriginAirportId(Integer originAirportId) {
        this.originAirportId = originAirportId;
    }

    public Integer getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(Integer destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
