package com.booking.vietjet.domain.booking.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookingRequest implements Serializable {

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("flightId")
    private Integer flightId;

    @JsonProperty("status")
    private Integer status; // Trạng thái (ví dụ: 1 - Đặt vé, 0 - Hủy vé)

    @JsonProperty("subtotal")
    private BigDecimal subtotal;

    @JsonProperty("discount")
    private BigDecimal discount;

    @JsonProperty("totalAmount")
    private BigDecimal totalAmount;

    @JsonProperty("note")
    private String note;

}
