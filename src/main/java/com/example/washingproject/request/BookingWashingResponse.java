package com.example.washingproject.request;

import java.util.Date;

public class BookingWashingResponse {

    private Date start;
    private Date end;
    private String roomNumber;
    private String name;
    private String weight;
    private boolean autoPower;
    private Long bookingId;
    private Long washingId;

    public BookingWashingResponse() {
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isAutoPower() {
        return autoPower;
    }

    public void setAutoPower(boolean autoPower) {
        this.autoPower = autoPower;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getWashingId() {
        return washingId;
    }

    public void setWashingId(Long washingId) {
        this.washingId = washingId;
    }
}
