package com.booking.vietjet.domain.booking.repository;

import com.booking.vietjet.domain.booking.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
