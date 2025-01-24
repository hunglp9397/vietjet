package com.booking.vietjet.domain.flight.service;

import com.booking.vietjet.app.common.ApiResponse;
import com.booking.vietjet.domain.common.ResponseCode;
import com.booking.vietjet.domain.flight.model.entity.Airport;
import com.booking.vietjet.domain.flight.repository.AirportRepository;
import com.booking.vietjet.infrastructure.service.CacheService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@Configuration
public class AirportService {

    private final AirportRepository airportRepository;

    private final CacheService cacheService;

    public ApiResponse getByCode(String code) {
        ApiResponse apiResponse = new ApiResponse();
        List<Airport> airportsResult = new LinkedList<>();
        try {
            List<Airport> airportsFromCache = (List<Airport>) cacheService.get(genKey(code));
            if (airportsFromCache != null) {
                airportsResult =  airportsFromCache;
            } else {
                airportsResult = airportRepository.findByCode(code);
                if (airportsResult != null && !airportsResult.isEmpty()) {
                    cacheService.set(genKey(code), airportsResult, 5);
                }
            }


        } catch (Exception e) {
            log.error("Error while getting airports {}", e.getMessage());
            apiResponse.setMessage(new ApiResponse.Message(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), e.getMessage()));
        }

        apiResponse.setData(airportsResult);
        apiResponse.setMessage(new ApiResponse.Message(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getType()));
        return apiResponse;
    }

    private String genKey(String key) {
        return "airport" + "::" + key;
    }


}
