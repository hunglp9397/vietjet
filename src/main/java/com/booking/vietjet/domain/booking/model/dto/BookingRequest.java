package com.booking.vietjet.domain.booking.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookingRequest {
    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("flightId")
    private Integer flightId;
    private Integer status; // Trạng thái (ví dụ: 1 - Đặt vé, 0 - Hủy vé)
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal totalAmount;
    private String note;



}
