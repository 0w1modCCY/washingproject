package com.example.washingproject.washer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasherRepository extends JpaRepository<Washer,Long> {

    Washer findWasherByName(String name);

    List<Washer> findWasherByBooked(boolean booked);

    Washer findWasherById(Long id);
}
