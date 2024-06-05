package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table( name = "booking")
public class Booking {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn (name = "flight_id")
    @JsonIgnoreProperties({"bookings"})
    private Flight flight;

    @ManyToOne
    @JoinColumn (name = "passenger_id")
    @JsonIgnoreProperties({"flights"})
    private Passenger passenger;

    @Column (name = "seatNumber")
    private int seatNumber;

    @Column (name = "mealPreference")
    private String mealPreference;

    public Booking(Flight flight, Passenger passenger, int seatNumber){
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.mealPreference = "Standard Meal";
    }

    public Booking(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getMealPreference() {
        return mealPreference;
    }

    public void setMealPreference(String mealPreference) {
        this.mealPreference = mealPreference;
    }
}
