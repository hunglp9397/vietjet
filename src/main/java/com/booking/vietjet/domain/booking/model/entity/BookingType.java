package com.booking.vietjet.domain.booking.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum BookingType {

    ONEWAY(0),    // 1 chiều
    ROUNDTRIP(1), // 2 chiều
    MULTICITY(2); // Nhiều chặng

    final int value;
    private static final Map<Integer, BookingType> VALUE_MAP = Stream.of(values())
            .collect(Collectors.toMap(BookingType::getValue, type -> type));

    public static BookingType of(int value) {
        return VALUE_MAP.getOrDefault(value, ONEWAY);
    }

}
