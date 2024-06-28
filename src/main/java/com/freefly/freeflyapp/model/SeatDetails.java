package com.freefly.freeflyapp.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class SeatDetails {

    private boolean isAvailable;
    private boolean isDirect;
    private int mileageCost;
    private int directMileageCost;
    private int numRemainingSeats;
    private int numDirectRemainingSeats;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isDirect() {
        return isDirect;
    }

    public void setDirect(boolean direct) {
        isDirect = direct;
    }

    public int getMileageCost() {
        return mileageCost;
    }

    public void setMileageCost(int mileageCost) {
        this.mileageCost = mileageCost;
    }

    public int getDirectMileageCost() {
        return directMileageCost;
    }

    public void setDirectMileageCost(int directMileageCost) {
        this.directMileageCost = directMileageCost;
    }

    public int getNumRemainingSeats() {
        return numRemainingSeats;
    }

    public void setNumRemainingSeats(int numRemainingSeats) {
        this.numRemainingSeats = numRemainingSeats;
    }

    public int getNumDirectRemainingSeats() {
        return numDirectRemainingSeats;
    }

    public void setNumDirectRemainingSeats(int numDirectRemainingSeats) {
        this.numDirectRemainingSeats = numDirectRemainingSeats;
    }
}
