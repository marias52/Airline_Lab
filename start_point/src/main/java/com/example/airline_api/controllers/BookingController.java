package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // Display all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingService.findAllBookings(), HttpStatus.OK);
    }

    // Add details of a new booking
    @PostMapping(value = "/{id}")
    public ResponseEntity<Booking> addNewBooking(@PathVariable long id){
        Optional<Booking> booking = bookingService.findSingleBooking(id);
        if (booking.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(booking.get(), HttpStatus.OK);
        }
    }

}
