package com.example.washingproject.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findBookingsByUserName(String userName);

    @Transactional
    @Modifying
    void deleteBookingById(Long id);
}
