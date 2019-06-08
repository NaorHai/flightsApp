package com.naor.flightapp.dao;

import com.naor.flightapp.entity.Ticket;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static com.naor.flightapp.Mocks.getTickets;

@Repository
public class TicketsDao implements Dao<Ticket, Integer> {
    private static Map<Integer, Ticket> tickets = new HashMap<>(getTickets());

    @Override
    public Ticket saveOrUpdate(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public Ticket get(Integer id) {
        return tickets.get(id);
    }
}
