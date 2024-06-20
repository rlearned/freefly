package com.freefly.freeflyapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Route {

    @Id
    @NotBlank
    private String routeID;

    @Column
    @NotBlank
    @Size(min = 3, max = 3)
    private String originAirport;

    @Column
    @NotBlank
    @Size(min = 3, max = 3)
    private String destinationAirport;

    @Column
    private String destinationRegion;

    @Column
    @Min(0)
    private int numDaysOut;

    @Column
    @Min(0)
    private int distance;

    @Column
    @NotBlank
    private String source;

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getDestinationRegion() {
        return destinationRegion;
    }

    public void setDestinationRegion(String destinationRegion) {
        this.destinationRegion = destinationRegion;
    }

    public int getNumDaysOut() {
        return numDaysOut;
    }

    public void setNumDaysOut(int numDaysOut) {
        this.numDaysOut = numDaysOut;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
