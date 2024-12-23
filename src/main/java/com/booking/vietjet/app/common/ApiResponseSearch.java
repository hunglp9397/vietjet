package com.booking.vietjet.app.common;

import lombok.Data;

@Data
public class ApiResponseSearch extends ApiResponse {
    private int limit;
    private int offset;
    private long totalCount;
}
