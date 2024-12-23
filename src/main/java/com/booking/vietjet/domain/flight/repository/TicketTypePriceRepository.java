package com.booking.vietjet.domain.flight.repository;

import com.booking.vietjet.domain.flight.model.entity.TicketTypePrice;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface TicketTypePriceRepository extends JpaRepository<TicketTypePrice, Long> {
}
