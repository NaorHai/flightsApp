package com.naor.flightapp.entity;

import java.util.List;
import java.util.UUID;

public class Flight {
    private final UUID id;
    private List<Integer> ticketIDsList;
    private int destination;

    public Flight(int destination) {
        this.id = UUID.randomUUID();
        this.destination = destination;
    }

    public UUID getId() {
        return this.id;
    }

    public int getDestination() {
        return destination;
    }

    public List<Integer> getTicketIDsList() {
        return ticketIDsList;
    }

    public void setTicketIDsList(List<Integer> ticketIDsList) {
        this.ticketIDsList = ticketIDsList;
    }
}
