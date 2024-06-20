package com.freefly.freeflyapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private boolean yAvailable;

    @Column(nullable = false)
    private boolean wAvailable;

    @Column(nullable = false)
    private boolean jAvailable;

    @Column(nullable = false)
    private boolean fAvailable;

    @Column(nullable = false)
    private boolean yDirect;

    @Column(nullable = false)
    private boolean wDirect;

    @Column(nullable = false)
    private boolean jDirect;

    @Column(nullable = false)
    private boolean fDirect;

    @Column(nullable = false)
    @Min(0)
    private int yMileageCost;

    @Column(nullable = false)
    @Min(0)
    private int wMileageCost;

    @Column(nullable = false)
    @Min(0)
    private int jMileageCost;

    @Column(nullable = false)
    @Min(0)
    private int fMileageCost;

    @Column(nullable = false)
    @Min(0)
    private int yDirectMileageCost;

    @Column(nullable = false)
    @Min(0)
    private int wDirectMileageCost;

    @Column(nullable = false)
    @Min(0)
    private int jDirectMileageCost;

    @Column(nullable = false)
    @Min(0)
    private int fDirectMileageCost;

    @Column(nullable = false)
    @Min(0)
    private int yRemainingSeats;

    @Column(nullable = false)
    @Min(0)
    private int wRemainingSeats;

    @Column(nullable = false)
    @Min(0)
    private int jRemainingSeats;

    @Column(nullable = false)
    @Min(0)
    private int fRemainingSeats;

    @Column(nullable = false)
    @Min(0)
    private int yDirectRemainingSeats;

    @Column(nullable = false)
    @Min(0)
    private int wDirectRemainingSeats;

    @Column(nullable = false)
    @Min(0)
    private int jDirectRemainingSeats;

    @Column(nullable = false)
    @Min(0)
    private int fDirectRemainingSeats;

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

    public boolean isyAvailable() {
        return yAvailable;
    }

    public void setyAvailable(boolean yAvailable) {
        this.yAvailable = yAvailable;
    }

    public boolean iswAvailable() {
        return wAvailable;
    }

    public void setwAvailable(boolean wAvailable) {
        this.wAvailable = wAvailable;
    }

    public boolean isjAvailable() {
        return jAvailable;
    }

    public void setjAvailable(boolean jAvailable) {
        this.jAvailable = jAvailable;
    }

    public boolean isfAvailable() {
        return fAvailable;
    }

    public void setfAvailable(boolean fAvailable) {
        this.fAvailable = fAvailable;
    }

    public boolean isyDirect() {
        return yDirect;
    }

    public void setyDirect(boolean yDirect) {
        this.yDirect = yDirect;
    }

    public boolean iswDirect() {
        return wDirect;
    }

    public void setwDirect(boolean wDirect) {
        this.wDirect = wDirect;
    }

    public boolean isjDirect() {
        return jDirect;
    }

    public void setjDirect(boolean jDirect) {
        this.jDirect = jDirect;
    }

    public boolean isfDirect() {
        return fDirect;
    }

    public void setfDirect(boolean fDirect) {
        this.fDirect = fDirect;
    }

    public int getyMileageCost() {
        return yMileageCost;
    }

    public void setyMileageCost(int yMileageCost) {
        this.yMileageCost = yMileageCost;
    }

    public int getwMileageCost() {
        return wMileageCost;
    }

    public void setwMileageCost(int wMileageCost) {
        this.wMileageCost = wMileageCost;
    }

    public int getjMileageCost() {
        return jMileageCost;
    }

    public void setjMileageCost(int jMileageCost) {
        this.jMileageCost = jMileageCost;
    }

    public int getfMileageCost() {
        return fMileageCost;
    }

    public void setfMileageCost(int fMileageCost) {
        this.fMileageCost = fMileageCost;
    }

    public int getyDirectMileageCost() {
        return yDirectMileageCost;
    }

    public void setyDirectMileageCost(int yDirectMileageCost) {
        this.yDirectMileageCost = yDirectMileageCost;
    }

    public int getwDirectMileageCost() {
        return wDirectMileageCost;
    }

    public void setwDirectMileageCost(int wDirectMileageCost) {
        this.wDirectMileageCost = wDirectMileageCost;
    }

    public int getjDirectMileageCost() {
        return jDirectMileageCost;
    }

    public void setjDirectMileageCost(int jDirectMileageCost) {
        this.jDirectMileageCost = jDirectMileageCost;
    }

    public int getfDirectMileageCost() {
        return fDirectMileageCost;
    }

    public void setfDirectMileageCost(int fDirectMileageCost) {
        this.fDirectMileageCost = fDirectMileageCost;
    }

    public int getyRemainingSeats() {
        return yRemainingSeats;
    }

    public void setyRemainingSeats(int yRemainingSeats) {
        this.yRemainingSeats = yRemainingSeats;
    }

    public int getwRemainingSeats() {
        return wRemainingSeats;
    }

    public void setwRemainingSeats(int wRemainingSeats) {
        this.wRemainingSeats = wRemainingSeats;
    }

    public int getjRemainingSeats() {
        return jRemainingSeats;
    }

    public void setjRemainingSeats(int jRemainingSeats) {
        this.jRemainingSeats = jRemainingSeats;
    }

    public int getfRemainingSeats() {
        return fRemainingSeats;
    }

    public void setfRemainingSeats(int fRemainingSeats) {
        this.fRemainingSeats = fRemainingSeats;
    }

    public int getyDirectRemainingSeats() {
        return yDirectRemainingSeats;
    }

    public void setyDirectRemainingSeats(int yDirectRemainingSeats) {
        this.yDirectRemainingSeats = yDirectRemainingSeats;
    }

    public int getwDirectRemainingSeats() {
        return wDirectRemainingSeats;
    }

    public void setwDirectRemainingSeats(int wDirectRemainingSeats) {
        this.wDirectRemainingSeats = wDirectRemainingSeats;
    }

    public int getjDirectRemainingSeats() {
        return jDirectRemainingSeats;
    }

    public void setjDirectRemainingSeats(int jDirectRemainingSeats) {
        this.jDirectRemainingSeats = jDirectRemainingSeats;
    }

    public int getfDirectRemainingSeats() {
        return fDirectRemainingSeats;
    }

    public void setfDirectRemainingSeats(int fDirectRemainingSeats) {
        this.fDirectRemainingSeats = fDirectRemainingSeats;
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
