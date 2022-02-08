package com.example.washingproject.washer;

import javax.persistence.*;

@Entity
@Table(name = "t_washer")
public class Washer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String weight;
    private boolean autoPower;
    private boolean booked;

    public Washer() {
        this.booked=false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean isAutoPower() {
        return autoPower;
    }

    public void setAutoPower(boolean autoPower) {
        this.autoPower = autoPower;
    }
}
