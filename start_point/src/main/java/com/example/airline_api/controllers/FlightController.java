package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    // TODO: Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable long id){
        Optional<Flight> flight = flightService.
        return ;
    }

    // TODO: Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(){
        return null;
    }

    // TODO: Extension - Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(){
        return null;
    }

}