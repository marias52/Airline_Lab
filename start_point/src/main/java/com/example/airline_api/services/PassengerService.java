package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    BookingRepository bookingRepository;


    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(long id){
        return passengerRepository.findById(id);

    }

    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

}
