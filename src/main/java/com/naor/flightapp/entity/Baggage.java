package com.naor.flightapp.entity;

import static com.naor.flightapp.utils.IDProvider.getNewBagId;

public class Baggage {
    private final String id;
    private final int ticketId;

    public Baggage(int ticketId) {
        this.id = getNewBagId();
        this.ticketId = ticketId;
    }

    public String getId() {
        return id;
    }

    public Integer getTicketId() {
        return ticketId;
    }
}
