package com.example.airline_api.services;


import com.example.airline_api.DTO.BookingDTO;
import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {


    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }


    public Optional<Booking> findSingleBooking(long id) {
        return bookingRepository.findById(id);

    }

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }


    public Booking saveCocoaOrder(BookingDTO bookingDTO) {

        Flight flight = flightService.findSingleFlight(bookingDTO.getFlightId()).get();
        Passenger passenger = passengerService.findSinglePassenger(bookingDTO.getPassengerId()).get();

        Booking booking = new Booking(
                flight,
                passenger,
                bookingDTO.getSeatNumber()
        );

        return booking;
    }

}