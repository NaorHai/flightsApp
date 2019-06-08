package com.naor.flightapp.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    private Map<Integer, TicketTTL> cache = new HashMap<>();

    public void set(int ticketId, boolean res) {
        cache.put(ticketId, new TicketTTL(res));
    }

    public Boolean get(int ticketId) {
        TicketTTL ticketTTL = cache.get(ticketId);
        if (ticketTTL == null) {
            return null;
        }
        if (ticketTTL.getTtl() < System.currentTimeMillis()) {
            return ticketTTL.getRes();
        }
        //expiration time passed
        cache.remove(ticketId);
        return null;
    }

    private class TicketTTL {
        private boolean res;
        private long ttl;

        final int EXPIRATION_TTL = 1000 * 30;

        public TicketTTL(boolean res) {
            this.res = res;
            this.ttl = System.currentTimeMillis() + EXPIRATION_TTL ;
        }

        public boolean getRes() {
            return res;
        }

        public void setRes(boolean res) {
            this.res = res;
        }

        public long getTtl() {
            return ttl;
        }

        public void setTtl(long ttl) {
            this.ttl = ttl;
        }
    }
}

