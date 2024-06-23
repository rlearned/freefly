package com.freefly.freeflyapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
public class Flight {

    @Id
    @NotBlank
    private String flightID;

    @ManyToOne
    @JoinColumn(name = "routeID", nullable = false)
    private Route route;

    @Column(nullable = false)
    private LocalDate date;

    @ElementCollection
    @CollectionTable(name = "seat_details", joinColumns = @JoinColumn(name = "flight_ID"))
    @MapKeyEnumerated(EnumType.STRING)
    private Map<SeatCategory, SeatDetails> seatDetails;

    @Column
    @NotBlank
    private String source;

    @Column
    @NotBlank
    private LocalDateTime createdAt;

    @Column
    @NotBlank
    private LocalDateTime updatedAt;

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
