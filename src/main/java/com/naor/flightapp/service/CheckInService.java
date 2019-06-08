package com.naor.flightapp.service;

import com.naor.flightapp.dao.BaggageDao;
import com.naor.flightapp.dao.FlightsDao;
import com.naor.flightapp.dao.TicketsDao;
import com.naor.flightapp.entity.Baggage;
import com.naor.flightapp.entity.Flight;
import com.naor.flightapp.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInService {

    private final TicketsDao ticketsDao;

    private final FlightsDao flightsDao;

    private final BaggageDao baggageDao;

    @Autowired
    public CheckInService(TicketsDao ticketsDao, FlightsDao flightsDao, BaggageDao baggageDao) {
        this.ticketsDao = ticketsDao;
        this.flightsDao = flightsDao;
        this.baggageDao = baggageDao;
    }

    public boolean doCheckIn(int destId, String bagId) {
        final Baggage baggage = baggageDao.get(bagId);
        if (baggage == null) {
            return false;
        }
        final Ticket ticket = ticketsDao.get(baggage.getTicketId());
        final Flight flight = flightsDao.get(ticket.getFlightId());

        return flight.getDestination() == destId;

    }
}
