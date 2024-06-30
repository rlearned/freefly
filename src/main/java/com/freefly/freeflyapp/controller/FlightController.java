package com.freefly.freeflyapp.controller;

import com.freefly.freeflyapp.service.FlightService;
import com.freefly.freeflyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;
}
