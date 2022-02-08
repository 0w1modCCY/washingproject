package com.example.washingproject.washerbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WasherBookRepository extends JpaRepository<WasherBooked,Long> {

    WasherBooked findWasherBookedByWasherId(Long id);
    WasherBooked findWasherBookedByBookingId(Long id);

    @Transactional
    @Modifying
    void deleteWasherBookedByBookingId(Long id);

}
