package com.naor.flightapp.service;

import com.naor.flightapp.dao.TicketsDao;
import com.naor.flightapp.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsService {
    final TicketsDao ticketsDao;

    @Autowired
    public TicketsService(TicketsDao ticketsDao) {
        this.ticketsDao = ticketsDao;
    }

    public boolean isTicketAvailable(int ticketId) {
        final Ticket ticket = ticketsDao.get(ticketId);
        return ticket != null && ticket.isAvailable();
    }
}
