package com.freefly.freeflyapp.service;

import com.freefly.freeflyapp.model.Flight;
import com.freefly.freeflyapp.model.Route;
import com.freefly.freeflyapp.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // TODO: commenting
    // TODO: Should take in a Route (supporting multiple origin and destinations)
    public List<Flight> getFlights(Route route) {

    }
}
