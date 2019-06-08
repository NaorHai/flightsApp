package com.naor.flightapp.dao;

import com.naor.flightapp.entity.Baggage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.naor.flightapp.Mocks.getBags;

@Service
public class BaggageDao implements Dao<Baggage, String> {
    private final Map<String, Baggage> baggage = new HashMap<>(getBags());


    @Override
    public Baggage saveOrUpdate(Baggage baggage) {
        this.baggage.put(baggage.getId(),baggage);
        return baggage;
    }

    @Override
    public Baggage get(String id) {
        return baggage.get(id);
    }
}
