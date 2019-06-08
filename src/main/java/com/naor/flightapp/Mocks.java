package com.naor.flightapp;

import com.naor.flightapp.entity.Baggage;
import com.naor.flightapp.entity.Flight;
import com.naor.flightapp.entity.Ticket;

import java.util.*;

public class Mocks {

    static Map<UUID, Flight> flights = new HashMap<>();
    static Map<Integer, Ticket> tickets = new HashMap<>();
    static Map<String, Baggage> bags = new HashMap<>();


    static Flight flight1 = new Flight(10);
    static Flight flight2 = new Flight(11);

    static Ticket ticket1 = new Ticket(flight1.getId());
    static Ticket ticket2 = new Ticket(flight2.getId());
    static Ticket ticket3 = new Ticket(flight1.getId());

    static Baggage baggage1 = new Baggage(ticket1.getId());
    static Baggage baggage2 = new Baggage(ticket2.getId());

    public static Map<UUID, Flight> getFlights() {
        flight1.setTicketIDsList(Arrays.asList(ticket1.getId(), ticket3.getId()));
        flight2.setTicketIDsList(Collections.singletonList(ticket2.getId()));

        flights.put(flight1.getId(), flight1);
        flights.put(flight2.getId(), flight2);

        return flights;
    }

    public static Map<Integer, Ticket> getTickets() {
        tickets.put(ticket1.getId(), ticket1);
        tickets.put(ticket2.getId(), ticket2);
        tickets.put(ticket3.getId(), ticket3);

        return tickets;
    }

    public static Map<String, Baggage> getBags() {
        bags.put(baggage1.getId(), baggage1);
        bags.put(baggage2.getId(), baggage2);

        return bags;
    }


}
