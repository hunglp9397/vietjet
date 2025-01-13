package com.booking.vietjet.app.filter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Component
public class IdempotenceFilter extends OncePerRequestFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.debug("Start IdempotenceFilter");
        String method = request.getMethod();
        String requestId = request.getHeader("REQUEST_ID");

        if(HttpMethod.POST.matches(method)){
            if (StringUtils.isBlank(requestId)) {
                log.warn("Request ID is blank.");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "REQUEST_ID is required");
            } else if (isRequestIdExistsInRedis(requestId)) {
                log.warn("Request ID {} already processed.", requestId);
                response.sendError(HttpServletResponse.SC_CONFLICT, "Duplicate REQUEST_ID detected");
            } else {
                storeRequestIdInRedis(requestId);

                // Continue filter chain
                filterChain.doFilter(request, response);
            }
        }


    }

    private boolean isRequestIdExistsInRedis(String requestId) {
        Boolean exists = redisTemplate.hasKey(requestId);
        return Boolean.TRUE.equals(exists);
    }

    private void storeRequestIdInRedis(String requestId) {
        redisTemplate.opsForValue().set(requestId, "processed", 5, TimeUnit.MINUTES);
        log.debug("Stored request ID {} in Redis with TTL 5 minutes", requestId);
    }

}
