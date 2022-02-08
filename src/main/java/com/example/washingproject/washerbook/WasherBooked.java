package com.example.washingproject.washerbook;

import javax.persistence.*;


@Entity
@Table(name = "t_washer_booked")
public class WasherBooked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private Long washerId;

    public WasherBooked() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getWasherId() {
        return washerId;
    }

    public void setWasherId(Long washerId) {
        this.washerId = washerId;
    }
}
