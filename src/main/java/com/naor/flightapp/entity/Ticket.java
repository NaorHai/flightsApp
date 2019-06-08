package com.naor.flightapp.entity;

import java.io.Serializable;
import java.util.UUID;

import static com.naor.flightapp.utils.IDProvider.getNewTicketId;

public class Ticket implements Serializable {
    private final int id;
    private boolean available;
    private int buggageId;
    private UUID flightId;

    public Ticket(UUID flightId) {
        this.id = getNewTicketId();
        this.available = true;
        this.flightId = flightId;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public UUID getFlightId() {
        return flightId;
    }
}
