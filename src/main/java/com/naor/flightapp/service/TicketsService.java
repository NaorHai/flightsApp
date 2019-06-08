package com.naor.flightapp.service;

import com.naor.flightapp.dao.TicketsDao;
import com.naor.flightapp.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsService {
    private final TicketsDao ticketsDao;
    private final CacheService cacheService;

    @Autowired
    public TicketsService(TicketsDao ticketsDao, CacheService cacheService) {
        this.ticketsDao = ticketsDao;
        this.cacheService = cacheService;
    }

    public boolean isTicketAvailable(int ticketId) {
        Boolean cacheRes = cacheService.get(ticketId);
        if (cacheRes != null) {
            return cacheRes;
        }
        final Ticket ticket = ticketsDao.get(ticketId);
        boolean res = ticket != null && ticket.isAvailable();
        cacheService.set(ticketId, res);
        return res;
    }
}
