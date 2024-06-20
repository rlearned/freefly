package com.freefly.freeflyapp.repository;

import com.freefly.freeflyapp.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
