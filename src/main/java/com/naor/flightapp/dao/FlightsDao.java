package com.naor.flightapp.dao;

import com.naor.flightapp.entity.Flight;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.naor.flightapp.Mocks.getFlights;

@Repository
public class FlightsDao implements Dao<Flight,UUID> {
    private Map<UUID, Flight> flights = new HashMap<>(getFlights());


    @Override
    public Flight saveOrUpdate(Flight flight) {
        flights.put(flight.getId(), flight);
        return flight;
    }

    @Override
    public Flight get(UUID id) {
        return flights.get(id);
    }
}
