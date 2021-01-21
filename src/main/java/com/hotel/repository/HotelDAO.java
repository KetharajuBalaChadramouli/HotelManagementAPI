package com.hotel.repository;

import com.hotel.dto.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDAO  extends JpaRepository<Hotel, Long> {
}
