package com.example.airline_api.controllers;

import com.example.airline_api.DTO.BookingDTO;
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

    @Autowired
    BookingDTO bookingDTO;

    // Display all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingService.findAllBookings(), HttpStatus.OK);
    }

    // Add details of a new booking
    @PostMapping
    public ResponseEntity<Booking> addNewBooking(@RequestBody BookingDTO bookingDTO){
        Booking booking = bookingService.addNewBooking(bookingDTO);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
    }

