package com.example.airline_api.components;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight flight1 = new Flight("london", 300, "01/01/01", "19:30");
        flightService.saveFlight(flight1);

        Passenger passenger1 = new Passenger("maria", "maria@hotmail.com");
        passengerService.savePassenger(passenger1);

        Booking booking1 = new Booking(flight1, passenger1, 32);
        bookingRepository.save(booking1);
    }

}
