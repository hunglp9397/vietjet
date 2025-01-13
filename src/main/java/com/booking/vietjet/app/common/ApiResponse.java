package com.booking.vietjet.app.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private T data;
    private Message message;

    @Data
    @AllArgsConstructor
    public static class Message {
        private int statusCode;
        private String message;
    }
}
