package com.example.airline_api.services;


import com.example.airline_api.models.Booking;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {


    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FlightService flightService;

    @Autowired
    BookingService bookingService;

    public List<Booking> findAllBookings(){
        return bookingRepository.findAll();
    }


}
